package hv.todolist.business.contract;


import java.util.List;

import hv.todolist.model.beans.*;

public interface ToDoList {
	
	/**
	 * Méthode permettant d'ajouter un nouvel utilisateur
	 * @param prenom : Prénom du nouvel utilisateur
	 * @param nom : Nom du nouvel utilisateur
	 * @param login : Identifiant du nouvel utilisateur
	 * @param password : Mot de passe du nouvel
	 * @return Retour le bean de l'utilisateur
	 */
	UserBean createNewUser(String prenom, String nom, String login, String password);
	
	/**
	 * Methode permettant de connecter un utilisateur
	 * @param login Identifiant de l'utilisateur
	 * @param password Mot de pass de l'utilisateur
	 * @return Retourne le Bean de l'utilisateur
	 */
	UserBean connectUser(String login, String password);
	
	/**
	 * Méthode renvoyant les listes de l'utilisateur
	 * @param user Bean de l'utilisateur
	 * @return Retoune la liste des listes de l'utilisateur
	 */
	List<ListBean> getListsForUser(UserBean user);
	
	/**
	 * Méthode permettant de créer une nouvelle liste pour l'utilisateur
	 * @param user Bean de l'utilisateur
	 * @return Retourne le bean de la nouvelle list
	 */
	ListBean createNewListFor(UserBean user);
	
	/**
	 * Méthode renvoyant la liste des taches d'une liste
	 * @param list Bean de la liste souhaitée
	 * @return Retourne la list des taches d'une liste
	 */
	List<TaskBean> getTasksForList(ListBean list);
	
}
