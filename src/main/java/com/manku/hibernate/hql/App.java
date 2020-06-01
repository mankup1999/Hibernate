//Persistence States

package com.manku.hibernate.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		
		SessionFactory sf=new Configuration().configure().addAnnotatedClass(Phone.class).buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		
		Phone p=new Phone();
		p.setPid(7);
		p.setName("Lenovo");
		p.setPrice(30000);
		
		session.save(p);
		
		p.setPrice(9000);
		
		session.getTransaction().commit();
		p.setPrice(10000);
		
		
		sf.close();

	}

}
