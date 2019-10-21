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
		boolean isExisting = usersDAOImpl.isUserWithLogin(login);
		return isExisting;
	}
	
	
	
	/**
	 * Enregistre le nouvel utilisateur
	 * @param user Le bean de l'utilisateur à été créé
	 * @return Le bean de l'utilisateur crée (si null, l'utilisateur n'a pas été créé
	 */
	public UserBean addUser(UserBean user) {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		Integer userId = usersDAOImpl.addUser(user);
		System.out.println(userId);
		if(userId!=null) {
			user.setId(userId);
		} else {
			user = null;
		}
		return user;
	}
	
	/**
	 * Supprime l'utilisateur avec l'identifiant
	 * @param login Identifiant de l'utilisateur
	 * @return retourne le nombre d'utilisateurs supprimés
	 */
	public int deleteUserWithLogin(String login) {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		int usersDeleted = usersDAOImpl.deleteUserWithLogin(login);
		return usersDeleted;
	}
	
	/**
	 * Vérifie la connexion de l'utilisateur
	 * @param login
	 * @param password
	 * @return
	 */
	public UserBean checkUserPassword(String login, String password) {
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		return usersDAOImpl.checkUserAuthentification(login, password);
	}
	
}
