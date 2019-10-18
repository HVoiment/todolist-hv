package hv.todolist.business.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import hv.todolist.business.impl.ToDoListImpl;
import hv.todolist.business.managers.UserManager;
import hv.todolist.model.beans.UserBean;

public class ToDoListImplTest {

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
	
}
