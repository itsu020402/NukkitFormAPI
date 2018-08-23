package itsu.mcbe.form.element;

import java.util.HashMap;
import java.util.Map;

public class Toggle implements FormElement {
	
	private String text;
	private boolean defaultValue;
	
	public Toggle() {
		this("");
	}
	
	public Toggle(String text) {
		this(text, false);
	}
	
	public Toggle(String text, boolean defaultValue) {
		this.text = text;
		this.defaultValue = defaultValue;
	}
	
	public Toggle setText(String text) {
		this.text = text;
		return this;
	}
	
	public Toggle setValue(boolean defaultValue) {
		this.defaultValue = defaultValue;
		return this;
	}
	
	public String getText() {
		return this.text;
	}
	
	public boolean getDefaultValue() {
		return defaultValue;
	}

	@Override
	public Map<String, Object> build() {
		Map<String, Object> data = new HashMap<>();
		
        data.put("type", "toggle");
        data.put("text", this.text);
        data.put("default", this.defaultValue);
        
		return data;
	}
	
	@Override
	public String getReturnType() {
		return "boolean";
	}
}
