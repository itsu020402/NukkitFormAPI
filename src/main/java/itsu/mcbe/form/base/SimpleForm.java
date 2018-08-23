package itsu.mcbe.form.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import itsu.mcbe.form.element.Button;
import itsu.mcbe.form.element.FormElement;

/**
 * <h1>NukkitFormAPI</h1>
 * <small>For Nukkit / NukkitX / Jupiter</small>
 * <br>
 * <br>
 * <h1>SimpleForm</h1>
 * <p>メニュー型のフォームを扱うクラスです。一般的にIDとタイトルを指定し、addButton(Button)で要素を追加して使います。ボタンクリック時の挙動はonEnter()メソッドをオーバーライドすることで実装できます。
 * <br><p>なお、Buttonクラスのボタン一つ一つに処理を割り振ることもできます。
 * <br>
 * 
 * @see SimpleForm#setId(int)
 * @see SimpleForm#setTitle(String)
 * @see SimpleForm#onEnter(int index)
 * @see Button
 * @see Button#onClick()
 * 
 * @author itsu
 *
 */

public class SimpleForm implements Form {

    private int id;
    private String title;
    private String content;
    private List<Button> buttons;

    private Map<String, Object> data;
    private Gson gson;
    private String json;

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - SimpleForm()</h1>
     * <p>SimpleFormのコンストラクタ。
     * <br>
     * 
     * @see SimpleForm#SimpleForm()
     * @see SimpleForm#SimpleForm(int)
     * @see SimpleForm#SimpleForm(int, String)
     * @see SimpleForm#SimpleForm(int, String, String)
     * @see SimpleForm#SimpleForm(int, String, String, List)
     * 
     * @author itsu
     *
     */
    public SimpleForm() {
        this(0, "");
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - SimpleForm(int id)</h1>
     * <p>SimpleFormのコンストラクタ。
     * <br>
     * 
     * @see SimpleForm#SimpleForm()
     * @see SimpleForm#SimpleForm(int)
     * @see SimpleForm#SimpleForm(int, String)
     * @see SimpleForm#SimpleForm(int, String, String)
     * @see SimpleForm#SimpleForm(int, String, String, List)
     * 
     * @author itsu
     *
     */
    public SimpleForm(int id) {
        this(id, "");
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - SimpleForm(int id, String title)</h1>
     * <p>SimpleFormのコンストラクタ。
     * <br>
     * 
     * @see SimpleForm#SimpleForm()
     * @see SimpleForm#SimpleForm(int)
     * @see SimpleForm#SimpleForm(int, String)
     * @see SimpleForm#SimpleForm(int, String, String)
     * @see SimpleForm#SimpleForm(int, String, String, List)
     * 
     * @author itsu
     *
     */
    public SimpleForm(int id, String title) {
        this(id, title, "");
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - SimpleForm(int id, String title, String content)</h1>
     * <p>SimpleFormのコンストラクタ。
     * <br>
     * 
     * @see SimpleForm#SimpleForm()
     * @see SimpleForm#SimpleForm(int)
     * @see SimpleForm#SimpleForm(int, String)
     * @see SimpleForm#SimpleForm(int, String, String)
     * @see SimpleForm#SimpleForm(int, String, String, List)
     * 
     * @author itsu
     *
     */
    public SimpleForm(int id, String title, String content) {
        this(id, title, content, new ArrayList<Button>());
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - SimpleForm(int id, String title, String content)</h1>
     * <p>SimpleFormのコンストラクタ。
     * <br>
     * 
     * @see SimpleForm#SimpleForm()
     * @see SimpleForm#SimpleForm(int)
     * @see SimpleForm#SimpleForm(int, String)
     * @see SimpleForm#SimpleForm(int, String, String)
     * @see SimpleForm#SimpleForm(int, String, String, List)
     * 
     * @author itsu
     *
     */
    public SimpleForm(int id, String title, String content, List<Button> buttons) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.buttons = buttons;

        data = new HashMap<>();
        gson = new Gson();
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - addButton(Button button)</h1>
     * <p>このフォームの最後部にボタンを追加します。addButtons()やsetButtonsで一括で追加することもできます。
     * <br>
     * 
     * @see SimpleForm#addButtons(List)
     * @see SimpleForm#addButtons(Button[])
     * @see SimpleForm#setButtons(List)
     * @see SimpleForm#setButtons(Button[])
     * 
     * @author itsu
     *
     */
    public SimpleForm addButton(Button button) {
        this.buttons.add(button);
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - setId(int id)</h1>
     * <p>このフォームにIDを設定します。コンストラクタで指定することもできます。
     * <br>
     * 
     * @see SimpleForm#SimpleForm(int)
     * 
     * @author itsu
     *
     */
    public SimpleForm setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - setTitle(String title)</h1>
     * <p>このフォームにタイトルを設定します。コンストラクタで指定することもできます。
     * <br>
     * 
     * @see SimpleForm#SimpleForm(int, String)
     * 
     * @author itsu
     *
     */
    public SimpleForm setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - setContent(String content)</h1>
     * <p>このフォームに表示する文章を設定します。コンストラクタで指定することもできます。
     * <br>
     * 
     * @see SimpleForm#SimpleForm(int, String, String)
     * 
     * @author itsu
     *
     */
    public SimpleForm setContent(String content) {
        this.content = content;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - setButtons(List<Button> buttons)</h1>
     * <p>このフォームに追加する要素を一括で設定します。コンストラクタで指定することもできます。
     * <br>
     * 
     * @see SimpleForm#SimpleForm(int, String, String, List)
     * 
     * @author itsu
     *
     */
    public SimpleForm setButtons(List<Button> buttons) {
        this.buttons = buttons;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - setButtons(Button[] buttons)</h1>
     * <p>このフォームに追加する要素を配列によって一括で設定します。コンストラクタで指定することもできます。
     * <br>
     * 
     * @see SimpleForm#SimpleForm(int, String, String, List)
     * 
     * @author itsu
     *
     */
    public SimpleForm setButtons(Button[] buttons) {
        this.buttons = Arrays.asList(buttons);
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - addButtons(List<Button> buttons)</h1>
     * <p>このフォームに要素を一括で追加します。setButtons()とはちがい、こちらでは一括追加後もaddButton()で要素を追加することができます。
     * <br>
     * 
     * @see SimpleForm#setButtons(List)
     * @see SimpleForm#addButton(FormElement)
     * 
     * @author itsu
     *
     */
    public SimpleForm addButtons(List<Button> buttons) {
        this.buttons.addAll(buttons);
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - addButtons(List<Button> buttons)</h1>
     * <p>このフォームに要素を配列によって一括で追加します。setButtons()とはちがい、こちらでは一括追加後もaddButton()で要素を追加することができます。
     * <br>
     * 
     * @see SimpleForm#setButtons(List)
     * @see SimpleForm#addButton(FormElement)
     * 
     * @author itsu
     *
     */
    public SimpleForm addButtons(Button[] buttons) {
        this.buttons.addAll(Arrays.asList(buttons));
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - getTitle()</h1>
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
     * <h1>SimpleForm - getContent()</h1>
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
     * <h1>SimpleForm - getButtons()</h1>
     * <p>このフォームのボタンを取得します。
     * <br>
     * 
     * @author itsu
     *
     */
    public List<Button> getButtons() {
        return this.buttons;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - getId()</h1>
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
     * <h1>SimpleForm - encode()</h1>
     * <p>このフォームをGsonライブラリ経由でJson化します。プラグイン側での呼び出しは非推奨です。
     * <br>
     * 
     * @author itsu
     *
     */
    @Override
    public SimpleForm encode() {
        json = gson.toJson(data);
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - build()</h1>
     * <p>このフォームをGsonライブラリ経由でJson化できるようにエンコードします。プラグイン側での呼び出しは非推奨です。
     * <br>
     * 
     * @author itsu
     *
     */
    @Override
    public SimpleForm build() {
        data.clear();

        data.put("type", "form");
        data.put("title", this.title);
        data.put("content", this.content);

        List<Map<String, Object>> list = new ArrayList<>();
        for(Button button : buttons) {
            Map<String, Object> map = new HashMap<>();
            map.put("text", button.getText());
            map.put("data", button.getImage());
            list.add(map);
        }

        data.put("buttons", list);

        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>SimpleForm - getJson()</h1>
     * <p>このフォームのJson化したものを取得します。なお、build()、encode()の順で呼び出しをした後でないとNullPointerExceptionを起こします。
     * <br>
     * 
     * @see SimpleForm#build()
     * @see SimpleForm#encode()
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
     * <h1>SimpleForm - onEnter(int index)</h1>
     * <p>このフォームのボタンをクリックした際に呼び出されます。indexはボタンのインデックスで、一番上から0, 1...なっていきます。とこのメソッドはプラグイン側でオーバーライドする必要があります。
     * <br>
     * 
     * @author itsu
     *
     */
    public void onEnter(int index) {

    }

}
