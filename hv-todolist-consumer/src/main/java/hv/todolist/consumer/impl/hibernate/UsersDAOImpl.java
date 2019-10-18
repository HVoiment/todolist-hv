package hv.todolist.consumer.impl.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import hv.todolist.consumer.hibernate.beans.Users;
import hv.todolist.model.beans.UserBean;


public class UsersDAOImpl {
	
	private final SessionFactory sessionFactory;
	
	public UsersDAOImpl() {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.out.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public Integer addUser(UserBean userBean) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer userid = null;
		if(userBean.getPrenom()!=null && userBean.getNom()!=null && userBean.getLogin()!=null && userBean.getPassword()!=null) {
			try {
			tx = session.beginTransaction();
			Users users = new Users(userBean.getPrenom(), userBean.getNom(), userBean.getLogin(), userBean.getPassword());
			userid = (int) session.save(users);
			tx.commit();
			} catch (HibernateException e) {
				if (tx!=null) tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		return userid;
	}
	
	
	public List<UserBean> listUsers() {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<UserBean> userList = new ArrayList<UserBean>();
		try {
			tx = session.beginTransaction();
			List result = session.createQuery("FROM Users").list();
			for (Iterator iterator = result.iterator(); iterator.hasNext();) {
				Users users = (Users) iterator.next();
				userList.add(new UserBean(users.getId(), users.getPrenom(), users.getNom(), users.getLogin(), users.getPassword()));
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userList;
	}
	
	public boolean isUserWithLogin(String login) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean isExisting = true;
		
		try {
			tx = session.getTransaction();
			String hql = "FROM Users WHERE login= :login";
			List result = session.createQuery(hql).setParameter("login", login).list();
			if(result.isEmpty()) {
				isExisting = false;
			} else {
				isExisting = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return isExisting;
		
	}
	
	
	/**
	 * Supprime l'utilisateur avec le login suivant
	 * @param login Login de l'utilisateur
	 * @return Retourn le nombre d'entitées supprimées
	 */
	public int deleteUserWithLogin(String login) {
		int entitiesDeleted = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hqlDelete = "DELETE Users WHERE login= :login";
			entitiesDeleted = session.createQuery(hqlDelete).setParameter("login", login).executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return entitiesDeleted;
	}
}