package itsu.mcbe.form.core;

import java.util.HashMap;
import java.util.Map;

import itsu.mcbe.form.base.Form;

public class DataCenter {
	
	private static Map<Integer, Form> forms;
	
	static {
		forms = new HashMap<>();
	}
	
	public static void addForm(int id, Form form) {
		forms.put(id, form);
	}
	
	public static Form getFormById(int id) {
		return forms.get(id);
	}

}
