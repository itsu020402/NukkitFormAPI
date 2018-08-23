# NukkitFormAPI
[![Travis](https://travis-ci.org/itsu020402/NukkitFormAPI.svg?branch=master)](https://travis-ci.org/itsu020402/NukkitFormAPI)  
  
NukkitやNukkitX、Jupiterなどでフォームを扱うAPIです。
レスポンス処理にも対応しており、わざわざプラグイン側でイベントリスナを作り、条件分岐によってフォームの処理を変えるなんて時代はもう終わりです。
このAPIではフォームやボタンに直接クリック時の処理を記述するという方法を採用しています。  
  
## APIの使用
APIの使用には、前提としてNukkitFormAPIをプラグインとして導入する必要があります。  
jarをpluginsフォルダに入れてください。  
  
## Mavenリポジトリ
pom.xmlに以下の記述をしてください。
    
    ・・・
    <repository>
        <id>github</id>
        <url>https://raw.github.com/itsu020402/NukkitFormAPI/mvn-repo/</url>
        <snapshots>
             <enabled>true</enabled>
             <updatePolicy>always</updatePolicy>
        </snapshots>
    </repository>
    
    ・・・
    <dependency>
    	<groupId>nukkit.form.api</groupId>
    	<artifactId>NukkitFormAPI</artifactId>
    	<version>2.0.1-SNAPSHOT</version>
    </dependency>
    
  
## APIリファレンス
### APIの取得
APIをスレッドセーフに取得することができます。

    //以下をインポート
    import itsu.mcbe.form.event.NukkitFormAPI;
      
    //onEnable内に記述
    NukkitFormAPI api = NukkitFormAPI.getSingleton();

### SimpleForm（ボタンを使ったメニュー型フォームの作成）

    Button button1 = new Button() {
        @Override
        public void onClick(Player player) {
            //ボタンクリック時の処理
        }
    }
        .setText("BUTTON_TEXT")
        .setImage("url", "IMAGE_URL");
        
    SimpleForm form = new SimpleForm() {
        @Override
        public void onEnter(Player player, int index) {
            //こっちはフォームにリスナを設置した場合。indexは押されたボタンのインデックスです。
        }
    }
        .setId(123)  //IDの設定
        .setTitle("TITLE")  //タイトルの設定
        .setContent("CONTENT_TEXT")  //表示する文章載の設定
        .addButton(button1);  //ボタンを追加
        //addButtons(List<Button>)で一括設定することもできます。
        
Buttonクラスの__onClick__メソッドをオーバーライドすることでボタンにリスナを設置することができます。  
または、SimpleFormクラスの__onEnter__メソッドをオーバーライドしてもリスナを設置できます。  
  
### ModalForm（二つのボタンと文章がついた簡易的なフォームの作成）

    ModalForm form = new ModalForm() {
        @Override
        public void onButton1Click(Player player) {
            //上のボタンをクリックしたときの処理
        }
        
        @Override
        public void onButton2Click(Player player) {
            //下のボタンをクリックしたときの処理
        }
    }
        .setId(123) //IDの設定
        .setTitle("TITLE")  //タイトルの設定
        .setContent("CONTENT_TEXT");  //表示する文章の設定
        
ModalFormクラスのonButton1Click()で上のボタン、onButton2Click()をオーバーライドすることで下のボタンのリスナをそれぞれ登録できます。  
  
### CustomForm（カスタムの要素を持ったフォームの作成）
    CustomForm form = new CustomForm() {
        @Override
        public void onEnter(Player player, List<Object> response) {
            //ここに「送信」ボタンを押したときの処理を書く。responseはそのフォームのレスポンスで、上にある要素から順にリストで返ってきます。
        }
    }
        .setId(123)  //ID
        .setTitle("TITLE")  //タイトル
        .addFormElement(new Label("LABEL_TEXT"))
        .addFormElement(new Input()
            .setText("INPUT_TEXT")
            .setPlaceHolder("PLACEHOLDER_TEXT")
            .setDefaultText("DEFAULT_TEXT")
            );
        //addFormElements(List<FormElements>)で一括設定もできます。
CustomFormクラスのonEnter(List<Object>)をオーバーライドすることでリスナを設置できます。  
  
### フォームの送信
    NukkitFormAPI.getSingleton().sendFormToPlayer(Player, Form);
を必ず使用して送信してください。  
