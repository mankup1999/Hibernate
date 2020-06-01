package com.manku.hibernate.hql;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Run {

	public static void main(String[] args) {
		
//		Phone p=new Phone();
//		p.setPid(5);
//		p.setName("Lava");
//		p.setPrice(5000);

		SessionFactory sf=new Configuration().configure().addAnnotatedClass(Phone.class).buildSessionFactory();
		
		Session session=sf.openSession();
		
		session.beginTransaction();
//		session.save(p);
//		Phone p=(Phone)session.get(Phone.class, 1);
//		Query q=session.createQuery("from Phone");
//		List<Phone> phones=q.list();
//		for(Phone p:phones)
//			System.out.println(p);
//		Query q=session.createQuery("select pid,name,price from Phone");
//		List<Object[]> phones=q.list();
//		for(Object[] p:phones)
//			System.out.println(p[0]+" : "+p[1]+" : "+p[2]);
//		int b=10000;
		
		SQLQuery q=session.createSQLQuery("select pid,name,price from Phone where price>10000");
//		q.addEntity(Phone.class);
		q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List phones=q.list();
		for(Object p:phones) {
			Map m=(Map)p;
			System.out.println(m.get("pid")+" : "+m.get("name")+" : "+m.get("price"));
		}
		
		session.getTransaction().commit();
		session.close();
//		System.out.println(p);

	}

}
