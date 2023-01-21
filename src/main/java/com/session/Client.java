package com.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		Student s1 = (Student) session.load(Student.class, 4);
		
		System.out.println("First student data is>>");
		System.out.println("Name>>" + s1.getName());
		System.out.println("City>>" + s1.getCity());
		System.out.println("Mobile>>" + s1.getMobile());

		System.out.println("second level cache>>");
		
		Session session1=sessionFactory.openSession();
		
		Student s3 = (Student) session1.load(Student.class, 5);
		
		System.out.println("Student data is>>");
		System.out.println("Name>>" + s3.getName());
		System.out.println("City>>" + s3.getCity());
		System.out.println("Mobile>>" + s3.getMobile());


	}

}
