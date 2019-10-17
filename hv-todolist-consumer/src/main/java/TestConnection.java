
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
		ListBean list = new ListBean("TODO", usr);
		list.setId(listsDAOImpl.addList(list));

		TaskBean task1 = new TaskBean("Prendre un verre ce soir", list);
		TaskBean task2 = new TaskBean("Sortir avec Anette", list);
		
		tasksDAOImpl.addTask(task1);
		tasksDAOImpl.addTask(task2);
		
		List<UserBean> lists = userDAOImpl.listUsers();
		for(UserBean user : lists) {
			System.out.println(user.getId());
			System.out.println(user.getPrenom());
			System.out.println(user.getNom());
			System.out.println(user.getLogin());
			System.out.println(user.getPassword());
			System.out.println("__________________________");
		}
		
		
		
		List<TaskBean> taskList = tasksDAOImpl.listTasks();
		for(TaskBean task : taskList) {
			System.out.println(task.getDescription());
			System.out.println("_______________");
		}

	}
	

}
