package itsu.mcbe.form.base;

public interface Form {
	
	public Form encode();
	
	public Form build();
	
	public String getJson();
	
	public int getId();

}
