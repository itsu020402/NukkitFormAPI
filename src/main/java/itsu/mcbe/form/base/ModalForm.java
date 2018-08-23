package itsu.mcbe.form.base;

import java.util.HashMap;
import java.util.Map;

import cn.nukkit.Player;
import com.google.gson.Gson;

/**
 * <h1>NukkitFormAPI</h1>
 * <small>For Nukkit / NukkitX / Jupiter</small>
 * <br>
 * <br>
 * <h1>ModalForm</h1>
 * <p>文章に二つのボタンがついた、簡易的なフォームを扱うクラスです。一般的にIDとタイトルを指定し、setButton1Text(String)とsetButton2Text(String)でボタンの文字列を設定して扱います。
 * <br><p>レスポンスの取得はonButton1Click()とonButton2Click()をオーバーライドして処理できます。
 * <br><p>なお、このAPI中のButton1は上のボタン、Button2は下のボタンとして扱っています。
 * <br>
 * 
 * @see ModalForm#setButton1Text(String)
 * @see ModalForm#setButton2Text(String)
 * @see ModalForm#onButton1Click(Player player)
 * @see ModalForm#onButton2Click(Player player)
 * 
 * @author itsu
 *
 */

public class ModalForm implements Form {

    private int id;
    private String title;
    private String content;
    private String button1Text;
    private String button2Text;

    private Map<String, Object> data;
    private Gson gson;
    private String json;
    
    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - ModalForm()</h1>
     * <p>ModalFormのコンストラクタ。
     * <br>
     * 
     * @see ModalForm#ModalForm()
     * @see ModalForm#ModalForm(int)
     * @see ModalForm#ModalForm(int, String)
     * @see ModalForm#ModalForm(int, String, String)
     * @see ModalForm#ModalForm(int, String, String, String, String)
     * 
     * @author itsu
     *
     */
    public ModalForm() {
        this(0);
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - ModalForm(int id)</h1>
     * <p>ModalFormのコンストラクタ。
     * <br>
     * 
     * @see ModalForm#ModalForm()
     * @see ModalForm#ModalForm(int)
     * @see ModalForm#ModalForm(int, String)
     * @see ModalForm#ModalForm(int, String, String)
     * @see ModalForm#ModalForm(int, String, String, String, String)
     * 
     * @author itsu
     *
     */
    public ModalForm(int id) {
        this(id, "");
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - ModalForm(int id, String title)</h1>
     * <p>ModalFormのコンストラクタ。
     * <br>
     * 
     * @see ModalForm#ModalForm()
     * @see ModalForm#ModalForm(int)
     * @see ModalForm#ModalForm(int, String)
     * @see ModalForm#ModalForm(int, String, String)
     * @see ModalForm#ModalForm(int, String, String, String, String)
     * 
     * @author itsu
     *
     */
    public ModalForm(int id, String title) {
        this(id, title, "");
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - ModalForm(int id, String title, String content)</h1>
     * <p>ModalFormのコンストラクタ。
     * <br>
     * 
     * @see ModalForm#ModalForm()
     * @see ModalForm#ModalForm(int)
     * @see ModalForm#ModalForm(int, String)
     * @see ModalForm#ModalForm(int, String, String)
     * @see ModalForm#ModalForm(int, String, String, String, String)
     * 
     * @author itsu
     *
     */
    public ModalForm(int id, String title, String content) {
        this(id, title, content, "", "");
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - ModalForm(int id, String title, String content, String button1Text, String button2Text)</h1>
     * <p>ModalFormのコンストラクタ。
     * <br>
     * 
     * @see ModalForm#ModalForm()
     * @see ModalForm#ModalForm(int)
     * @see ModalForm#ModalForm(int, String)
     * @see ModalForm#ModalForm(int, String, String)
     * @see ModalForm#ModalForm(int, String, String, String, String)
     * 
     * @author itsu
     *
     */
    public ModalForm(int id, String title, String content, String button1Text, String button2Text) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.button1Text = button1Text;
        this.button2Text = button2Text;

        data = new HashMap<>();
        gson = new Gson();
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - setId(int id)</h1>
     * <p>このフォームにIDを設定します。コンストラクタで指定することもできます。
     * <br>
     * 
     * @see ModalForm#ModalForm(int)
     * 
     * @author itsu
     *
     */
    public ModalForm setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - setTitle(String title)</h1>
     * <p>このフォームにタイトルを設定します。コンストラクタで指定することもできます。
     * <br>
     * 
     * @see ModalForm#ModalForm(int, String)
     * 
     * @author itsu
     *
     */
    public ModalForm setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - setContent(String content)</h1>
     * <p>このフォームに表示する文章を設定します。コンストラクタで指定することもできます。
     * <br>
     * 
     * @see ModalForm#ModalForm(int, String, String)
     * 
     * @author itsu
     *
     */
    public ModalForm setContent(String content) {
        this.content = content;
        return this;
    }
    
    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - setButton1Text(String button1Text)</h1>
     * <p>このフォームの上のボタンのテキストを設定します。コンストラクタで指定することもできます。
     * <br>
     * 
     * @see ModalForm#ModalForm(int, String, String, String, String)
     * 
     * @author itsu
     *
     */
    public ModalForm setButton1Text(String button1Text) {
        this.button1Text = button1Text;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - setButton2Text(String button1Text)</h1>
     * <p>このフォームの下のボタンのテキストを設定します。コンストラクタで指定することもできます。
     * <br>
     * 
     * @see ModalForm#ModalForm(int, String, String, String, String)
     * 
     * @author itsu
     *
     */
    public ModalForm setButton2Text(String button2Text) {
        this.button2Text = button2Text;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - getTitle()</h1>
     * <p>このフォームのタイトルを取得します。
     * <br>
     * 
     * @author itsu
     *
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - getContent()</h1>
     * <p>このフォームの文章を取得します。
     * <br>
     * 
     * @author itsu
     *
     */
    public String getContent() {
        return this.content;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - getButton1Text()</h1>
     * <p>このフォームの上のボタンのテキストを取得します。
     * <br>
     * 
     * @author itsu
     *
     */
    public String getButton1Text() {
        return this.button1Text;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - getButton1Text()</h1>
     * <p>このフォームの下のボタンのテキストを取得します。
     * <br>
     * 
     * @author itsu
     *
     */
    public String getButton2Text() {
        return this.button2Text;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - encode()</h1>
     * <p>このフォームをGsonライブラリ経由でJson化します。プラグイン側での呼び出しは非推奨です。
     * <br>
     * 
     * @author itsu
     *
     */
    @Override
    public Form encode() {
        json = gson.toJson(data);
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - build()</h1>
     * <p>このフォームをGsonライブラリ経由でJson化できるようにエンコードします。プラグイン側での呼び出しは非推奨です。
     * <br>
     * 
     * @author itsu
     *
     */
    @Override
    public Form build() {
        data.clear();

        data.put("type", "modal");
        data.put("title", this.title);
        data.put("content", this.content);
        data.put("button1", this.button1Text);
        data.put("button2", this.button2Text);

        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - getJson()</h1>
     * <p>このフォームのJson化したものを取得します。なお、build()、encode()の順で呼び出しをした後でないとNullPointerExceptionを起こします。
     * <br>
     * 
     * @see ModalForm#build()
     * @see ModalForm#encode()
     * @see NullPointerException
     * 
     * @author itsu
     *
     */
    @Override
    public String getJson() {
        return this.json;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - getId()</h1>
     * <p>このフォームのIdを取得します。
     * <br>
     * 
     * @author itsu
     *
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - onButton1Click(Player player)</h1>
     * <p>このフォームの上のボタンをクリックした際に呼び出されます。このメソッドはプラグイン側でオーバーライドする必要があります。
     * <br>
     * 
     * @author itsu
     *
     */
    public void onButton1Click(Player player) {

    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>ModalForm - onButton1Click(Player player)</h1>
     * <p>このフォームの下のボタンをクリックした際に呼び出されます。このメソッドはプラグイン側でオーバーライドする必要があります。
     * <br>
     * 
     * @author itsu
     *
     */
    public void onButton2Click(Player player) {

    }

}
