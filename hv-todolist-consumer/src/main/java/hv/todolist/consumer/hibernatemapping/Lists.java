package hv.todolist.consumer.hibernatemapping;

public class Lists {
	private Integer id;
	private String name;
	private Integer userid;
	
	public Lists() {
		
	}
	
	public Lists(String name, Integer userid) {
		this.name = name;
		this.userid = userid;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
}
