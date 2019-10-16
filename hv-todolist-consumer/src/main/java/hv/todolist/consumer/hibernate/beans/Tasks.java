package hv.todolist.consumer.hibernate.beans;

public class Tasks {
	private int id;
	private String description;
	private int listid;
	
	public Tasks() {
		// TODO Auto-generated constructor stub
	}
	
	public Tasks(String description, int listid) {
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
