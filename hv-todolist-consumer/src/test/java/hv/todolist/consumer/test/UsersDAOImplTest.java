package hv.todolist.consumer.test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
	@Test
	public final void GivenUserNotCorrect_WhenAddingUser_ThenUserIdShouldBeNull() {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		UserBean userBean = new UserBean();
		userBean.setPrenom("Elena");
		userBean.setLogin("EGas");
		Integer userId = usersDAOImpl.addUser(userBean);
		usersDAOImpl.deleteUserWithLogin(userBean.getLogin());
		assertNull(userId);
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

	/**
	 * 
	 * CHECK USER AUTHENTIFICATION
	 * 
	 */
	@Test
	public final void GiverUserWithGoodPassword_WhenCheckUserAuthentification() {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		UserBean usr  = new UserBean("Dam", "Le petit", "DLPetit2", "1234");
		usersDAOImpl.addUser(usr);
		usr = usersDAOImpl.checkUserAuthentification(usr.getLogin(), usr.getPassword());
		usersDAOImpl.deleteUserWithLogin(usr.getLogin());
		assertNotNull(usr);
		assertNotNull(usr.getId());
	}
	@Test
	public final void GiverUserWithBadPassword_WhenCheckUserAuthentification() {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		UserBean usr  = new UserBean("Dam", "Le petit", "DLPetit3", "1234");
		usersDAOImpl.addUser(usr);
		UserBean usrReturn = usersDAOImpl.checkUserAuthentification(usr.getLogin(), "5678");
		usersDAOImpl.deleteUserWithLogin(usr.getLogin());
		assertNull(usrReturn);
	}
	
}
