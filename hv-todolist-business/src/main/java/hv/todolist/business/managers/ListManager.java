package hv.todolist.business.managers;

import java.util.List;

import hv.todolist.consumer.impl.hibernate.ListsDAOImpl;
import hv.todolist.model.beans.ListBean;
import hv.todolist.model.beans.UserBean;

public class ListManager {

	
	/**
	 * Retourne la liste de listes de l'utilisateur
	 * @param user Bean de l'utilisateur choisi
	 * @return List des listes d'un utilisateur
	 */
	public List<ListBean> getListsFor(UserBean user) {
		ListsDAOImpl listsDAOImpl = new ListsDAOImpl();
		return listsDAOImpl.listLists(user);
	}

}
