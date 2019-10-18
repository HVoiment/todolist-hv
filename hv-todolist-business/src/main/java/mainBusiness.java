import hv.todolist.business.impl.ToDoListImpl;
import hv.todolist.business.managers.UserManager;
import hv.todolist.model.beans.UserBean;

public class mainBusiness {

	public static void main(String[] args) {
		
		ToDoListImpl toDoListImpl = new ToDoListImpl();
		UserBean usr = toDoListImpl.createNewUser("Henri", "Voiment", "HVoiment", "1234");
		System.out.println(usr);
		UserBean usr2 = toDoListImpl.createNewUser("Henri", "Voiment", "Jdoe", "1234");
		System.out.println(usr2);
		
	}
	
	
	
}
