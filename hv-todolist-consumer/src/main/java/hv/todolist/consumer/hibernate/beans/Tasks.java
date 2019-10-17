package hv.todolist.consumer.hibernate.beans;


import hv.todolist.model.beans.TaskBean;


public class Tasks {
	private int id;
	private String description;
	private Lists list;
	
	public Tasks() {
		// TODO Auto-generated constructor stub
	}
	
	public Tasks(String description, Lists list) {
		this.description = description;
		this.list = list;
	}
	
	public Tasks(TaskBean taskBean) {
		this.id = taskBean.getId();
		this.description = taskBean.getDescription();
		this.list = new Lists(taskBean.getList());
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
	public Lists getList() {
		return list;
	}
	public void setList(Lists list) {
		this.list = list;
	}
	
	public TaskBean getTaskBean() {
		return new TaskBean(id, description, list.getListBean());
	}
	

}
