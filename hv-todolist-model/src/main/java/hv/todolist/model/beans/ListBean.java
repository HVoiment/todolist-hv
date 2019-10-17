package hv.todolist.model.beans;

public class ListBean {
	private int id;
	private String name;
	private int iserid;
	
	public ListBean(int id, String name, int userid) {
		this.id = id;
		this.name = name;
		this.iserid = userid;
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
	public int getIserid() {
		return iserid;
	}
	public void setIserid(int iserid) {
		this.iserid = iserid;
	}

}
