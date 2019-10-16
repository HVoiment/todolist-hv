package hv.todolist.consumer.hibernate.hibernatemapping;

public class Tasks {
	private Integer id;
	private String description;
	private Integer listid;
	
	public Tasks() {
		// TODO Auto-generated constructor stub
	}
	
	public Tasks(String description, Integer listid) {
		this.description = description;
		this.listid = listid;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getListid() {
		return listid;
	}
	public void setListid(Integer listid) {
		this.listid = listid;
	}
	

}
