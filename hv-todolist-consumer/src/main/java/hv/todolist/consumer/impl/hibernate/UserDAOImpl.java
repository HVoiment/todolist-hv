package hv.todolist.consumer.impl.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDAOImpl {
	
	private static SessionFactory sessionFactory;
	
	public UserDAOImpl() {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
	
		} catch (Throwable ex) {
			System.out.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
	}
}
