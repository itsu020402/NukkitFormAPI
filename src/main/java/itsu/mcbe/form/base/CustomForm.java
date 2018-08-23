package itsu.mcbe.form.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.nukkit.Player;
import com.google.gson.Gson;

import itsu.mcbe.form.element.FormElement;

/**
 * <h1>NukkitFormAPI</h1>
 * <small>For Nukkit / NukkitX / Jupiter</small>
 * <br>
 * <br>
 * <h1>CustomForm</h1>
 * <p>独自でカスタムしたフォームを扱うクラスです。一般的にIDとタイトルを指定し、addFormElement(FormElement)で要素を追加して使います。「送信」ボタンクリック時の挙動はonEnter()メソッドをオーバーライドすることで実装できます。
 * <br>
 * 
 * @see CustomForm#addFormElement(FormElement)
 * @see CustomForm#setId(int)
 * @see CustomForm#setTitle(String)
 * @see CustomForm#onEnter(Player, List)
 * 
 * @author itsu
 *
 */

public class CustomForm implements Form {
	
    private int id;
    private String title;
    private List<FormElement> elements;
    
    private Map<String, Object> data;
    private Gson gson;
    private String json;
    
    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - CustomForm()</h1>
     * <p>CustomFormのコンストラクタ。
     * <br>
     * 
     * @see CustomForm#CustomForm()
     * @see CustomForm#CustomForm(int)
     * @see CustomForm#CustomForm(int, String)
     * @see CustomForm#CustomForm(int, String, List)
     * 
     * @author itsu
     *
     */
    public CustomForm() {
    	this(0);
    }
    
    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - CustomForm(int id)</h1>
     * <p>CustomFormのコンストラクタ。
     * <br>
     * 
     * @see CustomForm#CustomForm()
     * @see CustomForm#CustomForm(int)
     * @see CustomForm#CustomForm(int, String)
     * @see CustomForm#CustomForm(int, String, List)
     * 
     * @author itsu
     *
     */
    public CustomForm(int id) {
    	this(id, "");
    }
    
    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - CustomForm()</h1>
     * <p>CustomFormのコンストラクタ。
     * <br>
     * 
     * @see CustomForm#CustomForm(int id, String title)
     * @see CustomForm#CustomForm(int)
     * @see CustomForm#CustomForm(int, String)
     * @see CustomForm#CustomForm(int, String, List)
     * 
     * @author itsu
     *
     */
    public CustomForm(int id, String title) {
    	this(id, title, new ArrayList<FormElement>());
    }
    
    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - CustomForm(int id, String title, List elements)</h1>
     * <p>CustomFormのコンストラクタ。
     * <br>
     * 
     * @see CustomForm#CustomForm()
     * @see CustomForm#CustomForm(int)
     * @see CustomForm#CustomForm(int, String)
     * @see CustomForm#CustomForm(int, String, List)
     * 
     * @author itsu
     *
     */
    public CustomForm(int id, String title, List<FormElement> elements) {
        this.id = id;
        this.title = title;
        this.elements = elements;
        
        data = new HashMap<>();
        gson = new Gson();
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - setId(int id)</h1>
     * <p>このフォームにIDを設定します。コンストラクタで指定することもできます。
     * <br>
     * 
     * @see CustomForm#CustomForm(int)
     * 
     * @author itsu
     *
     */
    public CustomForm setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - setTitle(String title)</h1>
     * <p>このフォームにタイトルを設定します。コンストラクタで指定することもできます。
     * <br>
     * 
     * @see CustomForm#CustomForm(int, String)
     * 
     * @author itsu
     *
     */
    public CustomForm setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - setFormElements(List<FormElement> element)</h1>
     * <p>このフォームに追加する要素を一括で設定します。コンストラクタで指定することもできます。
     * <br>
     * 
     * @see CustomForm#CustomForm(int, String, List)
     * 
     * @author itsu
     *
     */
    public CustomForm setFormElements(List<FormElement> elements) {
        this.elements = elements;
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - setFormElements(FormElement[] element)</h1>
     * <p>このフォームに追加する要素を配列により一括で設定します。
     * <br>
     * 
     * @author itsu
     *
     */
    public CustomForm setFormElements(FormElement[] elements) {
        this.elements = Arrays.asList(elements);
        return this;
    }
    
    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - addFormElement(FormElement element)</h1>
     * <p>このフォームの最後部に要素を追加します。
     * <br>
     * 
     * @author itsu
     *
     */
    public CustomForm addFormElement(FormElement element) {
    	this.elements.add(element);
    	return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - addFormElements(List<FormElement> element)</h1>
     * <p>このフォームに要素を一括で追加します。setFormElements()とはちがい、こちらでは一括追加後もaddFormElement()で要素を追加することができます。
     * <br>
     * 
     * @see CustomForm#setFormElements(List)
     * @see CustomForm#addFormElement(FormElement)
     * 
     * @author itsu
     *
     */
    public CustomForm addFormElements(List<FormElement> elements) {
        this.elements.addAll(elements);
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - addFormElements(FormElement[] element)</h1>
     * <p>このフォームに要素を配列によって一括で追加します。setFormElements()とはちがい、こちらでは一括追加後もaddFormElement()で要素を追加することができます。
     * <br>
     * 
     * @see CustomForm#setFormElements(List)
     * @see CustomForm#addFormElement(FormElement)
     * 
     * @author itsu
     *
     */
    public CustomForm addFormElements(FormElement[] elements) {
        this.elements.addAll(Arrays.asList(elements));
        return this;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - getTitle()</h1>
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
     * <h1>CustomForm - getFormElements()</h1>
     * <p>このフォームの要素を取得します。
     * <br>
     * 
     * @author itsu
     *
     */
    public List<FormElement> getFormElements() {
        return this.elements;
    }

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - encode()</h1>
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
     * <h1>CustomForm - build()</h1>
     * <p>このフォームをGsonライブラリ経由でJson化できるようにエンコードします。プラグイン側での呼び出しは非推奨です。
     * <br>
     * 
     * @author itsu
     *
     */
	@Override
	public Form build() {
        data.clear();

        data.put("type", "custom_form");
        data.put("title", this.title);
        
        List<Map<String, Object>> list = new ArrayList<>();
        for(FormElement element : elements) {
        	list.add(element.build());
        }
        
        data.put("content", list);

        return this;
	}

    /**
     * <h1>NukkitFormAPI</h1>
     * <small>For Nukkit / NukkitX / Jupiter</small>
     * <br>
     * <br>
     * <h1>CustomForm - getJson()</h1>
     * <p>このフォームのJson化したものを取得します。なお、build()、encode()の順で呼び出しをした後でないとNullPointerExceptionを起こします。
     * <br>
     * 
     * @see CustomForm#build()
     * @see CustomForm#encode()
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
     * <h1>CustomForm - getId()</h1>
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
     * <h1>CustomForm - onEnter(Player player, List<Object> response)</h1>
     * <p>このフォームの「送信」ボタンをクリックした際に呼び出されます。このメソッドはプラグイン側でオーバーライドする必要があります。
     * <br>
     * 
     * @author itsu
     *
     */
	public void onEnter(Player player, List<Object> response) {
		
	}

}
