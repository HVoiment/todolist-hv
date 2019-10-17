package hv.todolist.consumer.impl.hibernate;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hv.todolist.consumer.hibernate.beans.Lists;
import hv.todolist.consumer.hibernate.beans.Users;
import hv.todolist.model.beans.ListBean;
import hv.todolist.model.beans.UserBean;




public class ListsDAOImpl {
	private final SessionFactory sessionFactory;
	
	public ListsDAOImpl() {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.out.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	
	public Integer addList(ListBean list) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer listid = null;
		try {
			tx = session.beginTransaction();
			Lists lists = new Lists(list.getName(), new Users(list.getUser()));
			listid = (Integer) session.save(lists);
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listid;
	}
	
	public List<ListBean> listLists(){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<ListBean> listList = new ArrayList<ListBean>();
		
		try {
			tx = session.beginTransaction();
			List result = session.createQuery("FROM Lists").list();
			for (Iterator iterator = result.iterator(); iterator.hasNext();) {
				Lists lists = (Lists) iterator.next();
				listList.add(lists.getListBean());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return listList;
		
	}
	
}
