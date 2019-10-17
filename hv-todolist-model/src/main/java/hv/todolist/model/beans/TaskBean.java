package hv.todolist.model.beans;

public class TaskBean {

	private int id;
	private String description;
	private ListBean list;
	
	public TaskBean(int id, String description, ListBean list) {
		this.id = id;
		this.description = description;
		this.list = list;
	}
	public TaskBean(String description, ListBean list) {
		this.description = description;
		this.list = list;
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
	public ListBean getList() {
		return list;
	}
	public void setList(ListBean list) {
		this.list = list;
	}
}
