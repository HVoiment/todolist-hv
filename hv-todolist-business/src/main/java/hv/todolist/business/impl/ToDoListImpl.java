package hv.todolist.business.impl;

import java.util.List;

import hv.todolist.business.contract.ToDoList;
import hv.todolist.business.managers.ListManager;
import hv.todolist.business.managers.UserManager;
import hv.todolist.model.beans.ListBean;
import hv.todolist.model.beans.TaskBean;
import hv.todolist.model.beans.UserBean;

public class ToDoListImpl implements ToDoList {

	@Override
	public UserBean createNewUser(String prenom, String nom, String login, String password) {
		UserBean user = new UserBean(prenom, nom, login, password);
		UserManager userManager = new UserManager();
		
		if(userManager.isUserExistForLogin(user.getLogin())) {
			return null;
		} else {
			user = userManager.addUser(user);
			if(user!=null) {
				return user;
			} else {
				return null;
			}
		}
	}

	@Override
	public UserBean connectUser(String login, String password) {
		UserManager userManager = new UserManager();
		if(userManager.isUserExistForLogin(login)) {
			return userManager.checkUserPassword(login, password);
		} else {
			return null;
		}
	}

	@Override
	public List<ListBean> getListsForUser(UserBean user) {
		ListManager listManager = new ListManager();
		return listManager.getListsFor(user);
	}

	@Override
	public ListBean createNewListFor(UserBean user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskBean> getTasksForList(ListBean list) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
