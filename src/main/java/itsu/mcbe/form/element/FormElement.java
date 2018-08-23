package itsu.mcbe.form.element;

import java.util.Map;

public interface FormElement {
	public Map<String, Object> build();
	public String getReturnType();
}
