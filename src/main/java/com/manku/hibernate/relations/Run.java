package com.manku.hibernate.relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Run {

	public static void main(String[] args) {
		
		Laptop l=new Laptop();
		l.setLid(103);
		l.setLname("Dell Vostro 15");
		
		Student s=new Student();
		s.setId(2);
		s.setName("Manku Pathak");
		//s.setLap(l);
		s.getLaps().add(l);
		
		l.getStu().add(s);
	
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Laptop.class)
				.buildSessionFactory();
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		//session.save(s);
		//session.save(l);
		Student student=(Student)session.get(Student.class, 2);
		
		System.out.println(student.getName());
		//for(Laptop laptop:student.getLaps())
		//	System.out.println(laptop.getLname());
		
		tx.commit();

	}

}
