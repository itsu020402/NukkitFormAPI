package itsu.mcbe.form.element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class Dropdown implements FormElement {

    private String text;
    private List<String> options = new ArrayList<String>();
    private int defaultOptionIndex = 0;
    
    private Gson gson;
    
    public Dropdown() {
    	this("");
    }
    
    public Dropdown(String text) {
    	this("", new ArrayList<String>());
    }

    public Dropdown(String text, List<String> options){
        this(text, options, 0);
    }

    public Dropdown(String text, List<String> options, int def){
        this.text = text;
        this.options = options;
        this.defaultOptionIndex = def;
        
        gson = new Gson();
    }
    
    public Dropdown setText(String text){
        this.text = text;
        return this;
    }

    public Dropdown setDefaultOptionIndex(int index){
        this.defaultOptionIndex = index;
        return this;
    }
    
    public Dropdown setOption(List<String> options){
        this.options = options;
        return this;
    }

    public String getText(){
        return this.text;
    }

    public List<String> getOptions(){
        return this.options;
    }

    public int getDefaultOptionIndex(){
        return this.defaultOptionIndex;
    }

    public Dropdown addOption(String option){
        this.options.add(option);
        return this;
    }

    public Dropdown removeOption(String option){
        if(this.options.contains(option)){
            this.options.remove(option);
        }
        return this;
    }

    public Dropdown resetOption(){
        this.options.clear();
        return this;
    }

    public int getOptionSize(){
        return this.options.size();
    }

	@Override
	public Map<String, Object> build() {
		Map<String, Object> data = new HashMap<>();
		
        data.put("type", "dropdown");
        data.put("text", this.text);
        data.put("options", this.options);
        data.put("default", this.defaultOptionIndex);
        
		return data;
	}
	
	@Override
	public String getReturnType() {
		return "int";
	}

}
