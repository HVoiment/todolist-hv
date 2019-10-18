package hv.todolist.consumer.test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import hv.todolist.consumer.impl.hibernate.UsersDAOImpl;
import hv.todolist.model.beans.UserBean;

public class UsersDAOImplTest {

	
	/**
	 * 
	 * ADDING USER
	 * 
	 */
	@Test
	public final void GivenUser_WhenAddingUser_ThenUserIdShouldNotBeNull() {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		UserBean userBean = new UserBean("Elena", "Gas", "EGas", "1234");
		Integer userId = usersDAOImpl.addUser(userBean);
		usersDAOImpl.deleteUserWithLogin(userBean.getLogin());
		assertNotNull(userId);
	}
	
	/**
	 * 
	 * LIST USERS
	 * 
	 */
	@Test
	public final void WhenListingUsers_ThenShouldListShouldBeNotEmpty() {
		UsersDAOImpl userDaoImpl = new UsersDAOImpl();
		List<UserBean> returnList = userDaoImpl.listUsers();
		assertFalse(returnList.isEmpty());
	}
	
	/**
	 * 
	 * IS EXISTING USER WITH LOGIN
	 * 
	 */
	@Test
	public final void GivenUserExists_WhenIsExistingUser_ThenShouldBeReturnTrue() {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		boolean isExisting = usersDAOImpl.isUserWithLogin("JDoe");
		assertTrue(isExisting);
	}
	@Test
	public final void GivenUserNotExists_WhenIsExistingUser_ThenShouldBeReturnFalse() {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		boolean isExisting = usersDAOImpl.isUserWithLogin("diejoqsozqsoz");
		assertFalse(isExisting);
	}
	
	/**
	 * 
	 * DELETING WITH USER LOGIN
	 * 
	 */
	@Test
	public final void GivenUserExist_WhenDeletingUserWithLogin_ThenShouldBeReturn1() {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		UserBean userBean = new UserBean("Dam", "Le grand", "DLGrand", "1234");
		usersDAOImpl.addUser(userBean);
		int entitiesDeleting = usersDAOImpl.deleteUserWithLogin(userBean.getLogin());
		assertTrue(entitiesDeleting == 1);
	}
	@Test
	public final void GivenUserNotExist_WhenDeletingUserWithLogin_ThenShouldBeReturn0() {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		UserBean userBean = new UserBean("Dam", "Le petit", "DLPetit", "1234");
		int entitiesDeleting = usersDAOImpl.deleteUserWithLogin(userBean.getLogin());
		assertTrue(entitiesDeleting == 0);
	}
	
	
}
