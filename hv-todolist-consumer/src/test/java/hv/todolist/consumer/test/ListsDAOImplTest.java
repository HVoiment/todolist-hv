package hv.todolist.consumer.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import hv.todolist.consumer.impl.hibernate.ListsDAOImpl;
import hv.todolist.consumer.impl.hibernate.UsersDAOImpl;
import hv.todolist.model.beans.ListBean;
import hv.todolist.model.beans.UserBean;

public class ListsDAOImplTest {

	/**
	 * 
	 * GET LIST
	 * 
	 */
	
	@Test
	public final void GivenUserHasLists_WhenGettingLists_ThenReturnListsShouldBeNotEmpty() {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		ListsDAOImpl listsDAOImpl = new ListsDAOImpl();
		UserBean userBean = new UserBean("Julien", "Leideck", "JLeideck", "1234");
		int userId = usersDAOImpl.addUser(userBean);
		userBean.setId(userId);
		ListBean listBean1 = new ListBean("Travail", userBean);
		ListBean listBean2 = new ListBean("Perso", userBean);
		listsDAOImpl.addList(listBean1);
		listsDAOImpl.addList(listBean2);
		List listReturn = listsDAOImpl.listLists(userBean);
		listsDAOImpl.deleteList(listBean1);
		listsDAOImpl.deleteList(listBean2);
		
		
		usersDAOImpl.deleteUserWithLogin(userBean.getLogin());
		assertFalse(listReturn.isEmpty());
	}

	@Test
	public final void GivenUserHasNoLists_WhenGettingLists_ThenReturnListsShouldBeEmpty() {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		ListsDAOImpl listsDAOImpl = new ListsDAOImpl();
		UserBean userBean = new UserBean("Julien", "Leideck", "JLeideck", "1234");
		int userId = usersDAOImpl.addUser(userBean);
		userBean.setId(userId);
		List listReturn = listsDAOImpl.listLists(userBean);
		usersDAOImpl.deleteUserWithLogin(userBean.getLogin());
		assertTrue(listReturn.isEmpty());
	}

	/**
	 * 
	 * DELETE LIST
	 * 
	 */

	@Test
	public final void GivenListExist_WhenDeletingList_ThenReturnShouldNotBe0() {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		ListsDAOImpl listsDAOImpl = new ListsDAOImpl();
		UserBean userBean = new UserBean("Julien", "Leideck", "JLeideck", "1234");
		int userId = usersDAOImpl.addUser(userBean);
		userBean.setId(userId);
		ListBean listBean1 = new ListBean("Travail", userBean);
		listsDAOImpl.addList(listBean1);
	
		int entitiesDeleted = listsDAOImpl.deleteList(listBean1);
		usersDAOImpl.deleteUserWithLogin(userBean.getLogin());
		assertFalse(entitiesDeleted==0);
	}
	
	@Test
	public final void GivenListNotExist_WhenDeletingList_ThenReturnShouldBe0() {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		ListsDAOImpl listsDAOImpl = new ListsDAOImpl();
		UserBean userBean = new UserBean("Julien", "Leideck", "JLeideck", "1234");
		int userId = usersDAOImpl.addUser(userBean);
		userBean.setId(userId);
		ListBean listBean1 = new ListBean("Travail", userBean);
		
	
		int entitiesDeleted = listsDAOImpl.deleteList(listBean1);
		usersDAOImpl.deleteUserWithLogin(userBean.getLogin());
		assertTrue(entitiesDeleted==0);
	}
}
