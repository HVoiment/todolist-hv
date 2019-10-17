package hv.todolist.business.test;





import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import hv.todolist.business.impl.ToDoListImpl;
import hv.todolist.model.beans.UserBean;

public class ToDoListImplTest {
	
	@Test
	public final void GivenNewUser_WhenCreatingNewUser_ThenShouldBeReturnUserBeanWithId() {
		ToDoListImpl toDoListImpl = new ToDoListImpl();
		UserBean user = toDoListImpl.createNewUser("John", "McCain", "JohnMC", "1234");
		assertNotNull(user.getId());
		assertEquals("John", user.getPrenom());
		assertEquals("McCain", user.getNom());
		assertEquals("JohnMC", user.getLogin());
		assertEquals("1234", user.getPassword());
	}
	
	@Test
	public final void GivenNewUserWithExistingLogin_WhenCreatingNewUser_ThenShouldBeReturnNull() {
		ToDoListImpl toDoListImpl = new ToDoListImpl();
		UserBean user = toDoListImpl.createNewUser("Henri", "Voiment", "JohnMC", "1234");
		assertNull(user);
	}
	
}
