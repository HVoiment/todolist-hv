package hv.todolist.consumer.hibernate.beans;

public class Lists {
	private int id;
	private String name;
	private int userid;
	
	public Lists() {
		
	}
	
	public Lists(String name, int userid) {
		this.name = name;
		this.userid = userid;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
