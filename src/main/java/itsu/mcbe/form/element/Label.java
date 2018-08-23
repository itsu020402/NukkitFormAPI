package itsu.mcbe.form.element;

import java.util.HashMap;
import java.util.Map;

public class Label implements FormElement {

    private String text;
    
    public Label() {
    	this("");
    }

    public Label(String text) {
        this.text = text;
    }
    
    public Label setText(String text) {
    	this.text = text;
    	return this;
    }

    public String getText() {
        return this.text;
    }

	@Override
	public Map<String, Object> build() {
		Map<String, Object> data = new HashMap<>();
		
        data.put("type", "label");
        data.put("text", this.text);
        
		return data;
	}
	
	
	@Override
	public String getReturnType() {
		return "null";
	}

}
