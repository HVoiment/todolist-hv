package hv.todolist.business.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import hv.todolist.business.impl.ToDoListImpl;
import hv.todolist.business.managers.UserManager;
import hv.todolist.consumer.impl.hibernate.ListsDAOImpl;
import hv.todolist.consumer.impl.hibernate.UsersDAOImpl;
import hv.todolist.model.beans.ListBean;
import hv.todolist.model.beans.UserBean;

public class ToDoListImplTest {

	/**
	 * 
	 * CREATE NEW USER
	 * 
	 */
	@Test
	public final void GivenUserNotExist_WhenCreatingNewUser_ThenShouldBeReturnNotNull() {
		ToDoListImpl toDoListImpl = new ToDoListImpl();
		UserManager usrManager = new UserManager();
		UserBean usr = new UserBean("Francois", "Gabart", "FGabart", "1234");
		usr = toDoListImpl.createNewUser(usr.getPrenom(), usr.getNom(), usr.getLogin(), usr.getPassword());
		usrManager.deleteUserWithLogin(usr.getLogin());
		assertNotNull(usr);
	}
	
	@Test
	public final void GivenUserExist_WhenCreatingNewUser_ThenShouldBeReturnNull() {
		ToDoListImpl toDoListImpl = new ToDoListImpl();
		UserManager usrManager = new UserManager();
		UserBean usr = new UserBean("Francois", "Gabart", "FGabart", "1234");
		usrManager.addUser(usr);
		UserBean usrretuned = toDoListImpl.createNewUser(usr.getPrenom(), usr.getNom(), usr.getLogin(), usr.getPassword());
		usrManager.deleteUserWithLogin(usr.getLogin());
		assertNull(usrretuned);
	}
	
	@Test
	public final void GivenUserNotCorrect_WhenCreatingNewUser_ThenShouldBeReturnNull() {
		ToDoListImpl toDoListImpl = new ToDoListImpl();
		UserBean usr = new UserBean();
		usr.setNom("dhuezq");
		usr.setPrenom("djexnq");
		usr = toDoListImpl.createNewUser(usr.getPrenom(), usr.getNom(), usr.getLogin(), usr.getPassword());
		assertNull(usr);
	}
	
	/**
	 * 
	 * CONNECT NEW USER
	 * 
	 */
	@Test
	public final void GivenFalseLogin_WhenConnectUser_ThenShouldBeReturnNull() {
		ToDoListImpl toDoListImpl = new ToDoListImpl();
		UserBean usr = new UserBean("Francois", "Gabart", "FGabart", "1234"); 
		UserManager userManager = new UserManager();
		userManager.addUser(usr);
		UserBean usrReturn = toDoListImpl.connectUser("desaqmdxend", "dzdszs");
		userManager.deleteUserWithLogin(usr.getLogin());
		assertNull(usrReturn);
	}
	@Test
	public final void GivenLoginAndBadPassword_WhenConnectUser_ThenShouldBeReturnNull() {
		ToDoListImpl toDoListImpl = new ToDoListImpl();
		UserBean usr = new UserBean("Francois", "Gabart", "FGabart", "1234"); 
		UserManager userManager = new UserManager();
		userManager.addUser(usr);
		UserBean usrReturn = toDoListImpl.connectUser(usr.getLogin(), "dzdszs");
		userManager.deleteUserWithLogin(usr.getLogin());
		assertNull(usrReturn);
	}
	@Test
	public final void GivenLoginAndGoodPassword_WhenConnectUser_ThenShouldBeReturnNotNull() {
		ToDoListImpl toDoListImpl = new ToDoListImpl();
		UserBean usr = new UserBean("Francois", "Gabart", "FGabart", "1234"); 
		UserManager userManager = new UserManager();
		userManager.addUser(usr);
		UserBean usrReturn = toDoListImpl.connectUser(usr.getLogin(), usr.getPassword());
		userManager.deleteUserWithLogin(usr.getLogin());
		assertNotNull(usrReturn);
	}
	
	/**
	 * 
	 * GET LIST FOR USER
	 * 
	 */
	@Test
	public final void GivenUser_WhenGettingUserList_ThenShouldBeReturnNotEmptyList() {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		ListsDAOImpl listsDAOImpl = new ListsDAOImpl();
		UserBean userBean = new UserBean("Francois", "Gabart", "FGabart", "1234"); 
		int userid = usersDAOImpl.addUser(userBean);
		userBean.setId(userid);
		
		ListBean listBean = new ListBean("Travail", userBean);
		ListBean listBean2 = new ListBean("Perso", userBean);
		listsDAOImpl.addList(listBean);
		listsDAOImpl.addList(listBean2);
		
		ToDoListImpl toDoListImpl = new ToDoListImpl();
		List resultList = toDoListImpl.getListsForUser(userBean);
		
		listsDAOImpl.deleteList(listBean);
		listsDAOImpl.deleteList(listBean2);
		usersDAOImpl.deleteUserWithLogin(userBean.getLogin());
		
		assertFalse(resultList.isEmpty());
		
		
		
		
	}
	
	@Test
	public final void GivenWrongUser_WhenGettingUserList_ThenShouldBeReturnNullList( ) {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		
		UserBean userBean = new UserBean(); 
		userBean.setPrenom("knjdieezs");
		userBean.setLogin("jdhedl");

		usersDAOImpl.addUser(userBean);
		
		
		
		
		ToDoListImpl toDoListImpl = new ToDoListImpl();
		List resultList = toDoListImpl.getListsForUser(userBean);
	
		usersDAOImpl.deleteUserWithLogin(userBean.getLogin());
		
		assertNull(resultList);
		
	}
	
	@Test
	public final void GivenUserAndDontHaveList_WhenGettingUserList_ThenShouldBeReturnEmptyList( ) {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		ListsDAOImpl listsDAOImpl = new ListsDAOImpl();
		UserBean userBean = new UserBean("Francois", "Gabart", "FGabart", "1234"); 
		int userid = usersDAOImpl.addUser(userBean);
		userBean.setId(userid);
		
		
		
		ToDoListImpl toDoListImpl = new ToDoListImpl();
		List resultList = toDoListImpl.getListsForUser(userBean);
	
		usersDAOImpl.deleteUserWithLogin(userBean.getLogin());
		
		assertTrue(resultList.isEmpty());
	}
	
}
