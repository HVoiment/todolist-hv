package hv.todolist.model.beans;

public class TaskBean {

	private int id;
	private String description;
	private int listid;
	
	public TaskBean(int id, String description, int listid) {
		this.id = id;
		this.description = description;
		this.listid = listid;
	}
	public TaskBean(String description, int listid) {
		this.description = description;
		this.listid = listid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getListid() {
		return listid;
	}
	public void setListid(int listid) {
		this.listid = listid;
	}
}
