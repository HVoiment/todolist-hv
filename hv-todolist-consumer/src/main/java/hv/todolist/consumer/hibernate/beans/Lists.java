package hv.todolist.consumer.hibernate.beans;

import hv.todolist.model.beans.ListBean;

public class Lists {
	private int id;
	private String name;
	private Users user;
	
	public Lists() {
		
	}
	
	public Lists(String name, Users user) {
		this.name = name;
		this.user = user;
	}
	
	public Lists(ListBean listBean) {
		this.id = listBean.getId();
		this.name = listBean.getName();
		this.user = new Users(listBean.getUser());
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
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	public ListBean getListBean() {
		return new ListBean(id, name, user.getUserBean());
	}
}
