package com.mavan.HibernateApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main 
{
	public static void main(String[] args) {
		//step 1
	Configuration configuration = new Configuration();
	configuration.configure("hibernate.cfg.xml");
	configuration.addAnnotatedClass(Student.class);
	
	//step 2
	SessionFactory sessionFactory=configuration.buildSessionFactory();
	
	//Step 3
	Session session=sessionFactory.openSession();
	//step 4
	Transaction transaction =session.beginTransaction();
	
	Student student=new Student(); //Transient
	//session.save(student); //persistent state
	student.setId(2);
	student.setName("Shadow");
	
	session.save(student); 
	transaction.commit();
	session.close();
}
	
}
