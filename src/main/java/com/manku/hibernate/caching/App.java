package com.manku.hibernate.caching;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		
		Book b=null;
		
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Book.class)
						.buildSessionFactory();
		System.out.println("1st Session...");
		Session session1=sf.openSession();
		session1.beginTransaction();
		Query q1=session1.createQuery("from Book where bid=1");
		q1.setCacheable(true);
		b=(Book)q1.uniqueResult();
		//b=(Book)session1.get(Book.class, 1);
		session1.getTransaction().commit();
		session1.close();
		
		System.out.println("2nd Session...");
		Session session2=sf.openSession();
		session2.beginTransaction();
		Query q2=session2.createQuery("from Book where bid=1");
		q2.setCacheable(true);
		b=(Book)q2.uniqueResult();
		//b=(Book)session2.get(Book.class, 1);
		session2.getTransaction().commit();
		session2.close();

	}

}
