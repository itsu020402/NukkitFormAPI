package itsu.mcbe.form.element;

import java.util.HashMap;
import java.util.Map;

public class Slider implements FormElement {

    private String text;
    private float min = 0.0f;
    private float max = 0.0f;
    private float step = 0.0f;
    private float defaultValue = 0.0f;
    
    public Slider() {
    	this("");
    }
    
    public Slider(String text) {
    	this("", 0.0f);
    }

    public Slider(String text, float max) {
        this(text, 0, max);
    }

    public Slider(String text, float min, float max) {
        this(text, min, max, 0.0f);
    }

    public Slider(String text, float min, float max, float step) {
        this(text, min, max, 0.0f, 0.0f);
    }

    public Slider(String text, float min, float max, float step, float defaultValue) {
        this.text = text;
        this.min = min;
        this.max = max;
        this.step = step;
        this.defaultValue = defaultValue;
    }

    public Slider setText(String text) {
        this.text = text;
        return this;
    }

    public Slider setMin(float min) {
        this.min = min;
        return this;
    }

    public Slider setMax(float max) {
        this.max = max;
        return this;
    }

    public Slider setStep(float step) {
        this.step = step;
        return this;
    }

    public Slider setDefaultValue(float defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public String getText() {
        return this.text;
    }

    public float getMin() {
        return this.min;
    }

    public float getMax() {
        return this.max;
    }

    public float getStep() {
        return this.step;
    }

    public float getDefaultValue() {
        return this.defaultValue;
    }

	@Override
	public Map<String, Object> build() {
		Map<String, Object> data = new HashMap<>();
		
        data.put("type", "slider");
        data.put("text", this.text);
        data.put("min", this.min);
        data.put("max", this.max);
        
        if(this.step > 0) data.put("step", this.step);
        if(this.defaultValue != this.min) data.put("default", this.defaultValue);
        
		return data;
	}
	
	
	@Override
	public String getReturnType() {
		return "float";
	}

}
