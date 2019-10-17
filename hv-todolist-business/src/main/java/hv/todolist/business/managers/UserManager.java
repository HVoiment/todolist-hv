package hv.todolist.business.managers;

import hv.todolist.consumer.impl.hibernate.UsersDAOImpl;
import hv.todolist.model.beans.UserBean;

public class UserManager {

	
	/**
	 * Vérifie si le login existe déjà
	 * @param login le login entré par l'utilisateur
	 * @return Retourne si l'utilisateur existe
	 */
	public boolean isUserExistForLogin(String login) {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		return usersDAOImpl.isUserWithLogin(login);
	}
	
	
	/**
	 * Enregistre le nouvel utilisateur
	 * @param user Le bean de l'utilisateur à été créé
	 * @return Le bean de l'utilisateur crée (si null, l'utilisateur n'a pas été créé
	 */
	public UserBean addUser(UserBean user) {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		Integer userId = usersDAOImpl.addUser(user);
		if(userId!=null) {
			user.setId(userId);
		} else {
			user = null;
		}
		return user;
	}
	
}
