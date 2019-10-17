package hv.todolist.consumer.impl.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hv.todolist.consumer.hibernate.beans.Lists;
import hv.todolist.consumer.hibernate.beans.Tasks;
import hv.todolist.model.beans.ListBean;
import hv.todolist.model.beans.TaskBean;


public class TasksDAOImpl {
	private final SessionFactory sessionFactory;
	
	public TasksDAOImpl() {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.out.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public Integer addTask(TaskBean task) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer taskid = null;
		try {
			tx = session.beginTransaction();
			Tasks tasks = new Tasks(task.getDescription(), new Lists(task.getList()));
			taskid = (Integer) session.save(tasks);
			tx.commit();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return taskid;
	}
	
	public List<TaskBean> listTasks(){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<TaskBean> taskList = new ArrayList<TaskBean>();
		try {
			tx = session.beginTransaction();
			List result = session.createQuery("FROM Tasks").list();
			for (Iterator iterator = result.iterator(); iterator.hasNext();) {
				Tasks task = (Tasks) iterator.next();
				taskList.add(task.getTaskBean());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return taskList;
	}
	
}
