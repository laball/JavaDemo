package com.demo.hibernatedemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	private static SessionFactory factory;

	public static void main(String[] args) {

		try {
			factory = new Configuration().configure().buildSessionFactory();

		} catch (Exception e) {
			System.out.printf(e.getMessage());
			return;
		}

		if (factory == null) {
			System.out.print("Build SessionFactory Failed.");
			return;
		}

		Session session = factory.openSession();
		if (session != null) {

			SQLQuery query = session.createSQLQuery("select count(*) from org");
			if (query != null) {
				ArrayList<?> object = (ArrayList<?>) query.list();
				System.out.print(object.get(0));
			}

			System.out.print("\r\n");
		}

		com.demo.hibernatedemo.Org org1 = session.get(Org.class, 1);
		if (org1 != null) {

			System.out.print(org1.getName());
		}

		Query query = session.createQuery("from Org");// HQL
		List<?> orgs = query.list();
		java.util.Iterator<Org> iterator = (Iterator<Org>) orgs.iterator();

		while (iterator.hasNext()) {

			Org org = iterator.next();

			System.out.print("ID:" + org.getId() + " Name:" + org.getName() + "\r\n");
		}

	}

}
