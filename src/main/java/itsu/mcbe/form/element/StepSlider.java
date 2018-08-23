package itsu.mcbe.form.element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StepSlider implements FormElement {
    
    private List<String> steps = new ArrayList<String>();
    private int defaultIndex;
    private String text;
    
    public StepSlider() {
    	this("");
    }
    
    public StepSlider(String text) {
    	this(text, new ArrayList<String>());
    }
    
    public StepSlider(String text, List<String> steps) {
    	this(text, steps, 0);
    }

    public StepSlider(String text, List<String> steps, int defaultIndex) {
        this.text = text;
        this.steps = steps;
        this.defaultIndex = defaultIndex;
    }

    public StepSlider setText(String text) {
        this.text = text;
        return this;
    }
    
    public StepSlider setSteps(List<String> steps) {
        this.steps = steps;
        return this;
    }

    public StepSlider setDefaultIndex(int index) {
        this.defaultIndex = index;
        return this;
    }

    public String getText() {
        return this.text;
    }
    
    public List<String> getSteps() {
        return this.steps;
    }

    public int getDefaultIndex() {
        return this.defaultIndex;
    }

    public StepSlider addStep(String step){
        if(!(this.steps.contains(steps))) {
            this.steps.add(step);
        }
        return this;
    }

    public StepSlider removeStep(int step) {
        if(this.steps.contains(step)) {
            this.steps.remove((Integer) step);
        }
        return this;
    }

    public StepSlider removeSteps() {
        this.steps.clear();
        return this;
    }

	@Override
	public Map<String, Object> build() {
		Map<String, Object> data = new HashMap<>();
		
        data.put("type", "step_slider");
        data.put("text", this.text);
        data.put("steps", this.steps);
        data.put("default", this.defaultIndex);
        
		return data;
	}
	
	@Override
	public String getReturnType() {
		return "int";
	}

}
