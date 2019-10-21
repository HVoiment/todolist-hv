package hv.todolist.business.test.manager;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import hv.todolist.business.managers.ListManager;
import hv.todolist.consumer.impl.hibernate.ListsDAOImpl;
import hv.todolist.consumer.impl.hibernate.UsersDAOImpl;
import hv.todolist.model.beans.ListBean;
import hv.todolist.model.beans.UserBean;

public class ListManagerTest {

	
	@Test
	public final void GivenUser_WhenGettingUserList_ThenShouldBeReturnNotEmptyList() {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		UserBean userbean = new UserBean("Alain", "Voiment", "AVoiment", "1234");
		int id = usersDAOImpl.addUser(userbean);
		userbean.setId(id);
		
		ListsDAOImpl listsDAOImpl = new ListsDAOImpl();
		ListBean list1 = new ListBean("Travail", userbean);
		ListBean list2 = new ListBean("Personelle", userbean);
		listsDAOImpl.addList(list1);
		listsDAOImpl.addList(list2);
		
		ListManager listManager = new ListManager();
		List listResult = listManager.getListsFor(userbean);
		
		listsDAOImpl.deleteList(list1);
		listsDAOImpl.deleteList(list2);
		
		usersDAOImpl.deleteUserWithLogin(userbean.getLogin());
		
		assertFalse(listResult.isEmpty());
	}
	
	@Test
	public final void GivenWrongUser_WhenGettingUserList_ThenShouldBeReturnNullList( ) {
		UserBean userBean = new UserBean();
		userBean.setPrenom("cndncd");
		userBean.setLogin("jrde");
		ListManager listManager = new ListManager();
		List listresult = listManager.getListsFor(userBean);
		
		assertNull(listresult);
	}
	
	@Test
	public final void GivenUserAndDontHaveList_WhenGettingUserList_ThenShouldBeReturnEmptyList( ) {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		UserBean userbean = new UserBean("Alain", "Voiment", "AVoiment", "1234");
		int id = usersDAOImpl.addUser(userbean);
		userbean.setId(id);
	
		
		ListManager listManager = new ListManager();
		List listResult = listManager.getListsFor(userbean);
		

		usersDAOImpl.deleteUserWithLogin(userbean.getLogin());
		
		assertTrue(listResult.isEmpty());
	}
}
