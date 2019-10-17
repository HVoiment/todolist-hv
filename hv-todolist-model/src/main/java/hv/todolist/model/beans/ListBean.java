package hv.todolist.model.beans;

public class ListBean {
	private int id;
	private String name;
	private UserBean user;
	
	public ListBean(int id, String name, UserBean user) {
		this.id = id;
		this.name = name;
		this.user = user;
	}
	
	public ListBean(String name, UserBean user) {
		this.name = name;
		this.user = user;
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
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}

}
