package com.manku.hibernate.ExampleHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DemoRun {

	public static void main(String[] args) {

		Name name=new Name();
		name.setFname("Manku");
		name.setLname("Pathak");
		
		Account acc=new Account();
		acc.setId(104);
		acc.setName(name);
		acc.setBalance(100000);
		

		Configuration con=new Configuration().configure().addAnnotatedClass(Account.class);
		
		ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		
		SessionFactory sf=con.buildSessionFactory(reg);
		
		Session session=sf.openSession();
		
		Transaction tr=session.beginTransaction();
		session.save(acc);
		//Account acc1=(Account)session.get(Account.class, 104);
		tr.commit();
		
		//System.out.println(acc1);
	}

}
