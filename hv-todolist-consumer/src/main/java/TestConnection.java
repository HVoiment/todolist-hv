
import java.util.List;

import hv.todolist.consumer.impl.hibernate.ListsDAOImpl;
import hv.todolist.consumer.impl.hibernate.TasksDAOImpl;
import hv.todolist.consumer.impl.hibernate.UsersDAOImpl;
import hv.todolist.model.beans.ListBean;
import hv.todolist.model.beans.TaskBean;
import hv.todolist.model.beans.UserBean;

public class TestConnection {

	public static void main(String[] args) {
		UsersDAOImpl userDAOImpl = new UsersDAOImpl();
		ListsDAOImpl listsDAOImpl = new ListsDAOImpl();
		TasksDAOImpl tasksDAOImpl = new TasksDAOImpl();
		UserBean usr = new UserBean("John", "Doe", "JDoe", "JJoe1234");
		usr.setId(userDAOImpl.addUser(usr));
		ListBean list1 = new ListBean("TODO", usr);
		ListBean list2 = new ListBean("Travail", usr);
		list1.setId(listsDAOImpl.addList(list1));
		list2.setId(listsDAOImpl.addList(list2));
		
		
		List<UserBean> userList = userDAOImpl.listUsers();
		for(UserBean user : userList) {
			System.out.println(user.getId());
			System.out.println(user.getPrenom());
			System.out.println(user.getNom());
			System.out.println(user.getLogin());
			System.out.println(user.getPassword());
			System.out.println("__________________________");
		}
		List<ListBean> lists = listsDAOImpl.listLists(usr);
		for(ListBean list : lists) {
			System.out.println(list.getId());
			System.out.println(list.getName());
			System.out.println(list.getUser().getLogin());
			System.out.println("__________________________");
		}
		
		
		

	}
	

}
