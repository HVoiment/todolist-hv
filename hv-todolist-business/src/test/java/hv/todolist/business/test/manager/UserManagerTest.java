package hv.todolist.business.test.manager;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import hv.todolist.business.managers.UserManager;

public class UserManagerTest {

	@Test
	public final void GivenUserExist_WhenIsExisting_ThenReturnSouldBeTrue() {
		UserManager userManager = new UserManager();
		boolean result = userManager.isUserExistForLogin("JDoe");
		assertTrue(result);
	}
	
	@Test
	public final void GivenUserNotExist_WhenIsExisting_ThenShouldBeReturnBeFalse() {
		UserManager userManager = new UserManager();
		boolean result = userManager.isUserExistForLogin("JohnMC");
		userManager.deleteUserWithLogin("JohnMC");
		assertFalse(result);
	}
	
	@Test
	public final void GivenNewUser_WhenAddingNewUser_ThenShouldBeReturnUserWithId() {
		UserManager userManager = new UserManager();
		
	}
}
