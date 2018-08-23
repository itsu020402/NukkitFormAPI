package itsu.mcbe.form.element;

import java.util.HashMap;
import java.util.Map;

public class Input implements FormElement {

    private String text;
    private String placeHolder;
    private String defaultText;
    
    public Input() {
    	this("");
    }
    
    public Input(String text) {
    	this(text, "");
    }
    
    public Input(String text, String placeHolder) {
    	this(text, placeHolder, "");
    }

    public Input(String text, String placeHolder, String defaultText){
        this.text = text;
        this.placeHolder = placeHolder;
        this.defaultText = defaultText;
    }
    
    public Input setText(String text) {
    	this.text = text;
    	return this;
    }
    
    public Input setPlaceHolder(String placeHolder) {
    	this.placeHolder = placeHolder;
    	return this;
    }
    
    public Input setDefaultText(String defaultText) {
    	this.defaultText = defaultText;
    	return this;
    }

    public String getText(){
        return this.text;
    }

    public String getPlaceHolder(){
        return this.placeHolder;
    }

    public String getDefaultText(){
        return this.defaultText;
    }

	@Override
	public Map<String, Object> build() {
		Map<String, Object> data = new HashMap<>();
		
        data.put("type", "input");
        data.put("text", this.text);
        data.put("placeholder", this.placeHolder);
        data.put("default", this.defaultText);
        
		return data;
	}
	
	@Override
	public String getReturnType() {
		return "string";
	}
}
