package hv.todolist.consumer.hibernate.beans;

import hv.todolist.model.beans.UserBean;

public class Users {
	private int id;
	private String prenom;
	private String nom;
	private String login;
	private String password;
	
	public Users() {
		
	}
	
	public Users(String prenom, String nom, String login, String password) {
		this.prenom = prenom;
		this.nom = nom;
		this.login = login;
		this.password = password;
	}
	
	public Users(UserBean userBean) {
		this.id = userBean.getId();
		this.prenom = userBean.getPrenom();
		this.nom = userBean.getNom();
		this.login = userBean.getLogin();
		this.password = userBean.getPassword();
	}
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public UserBean getUserBean() {
		return new UserBean(id, prenom, nom, login, password);
	}
	
}
