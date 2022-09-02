package com.viva903.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.viva903.aopdemo.dao.AccountDAO;

public class MainApp {

	public static void main(String[] args) {

//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

//		get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("AccountDAO", AccountDAO.class);

//		call the business method
		theAccountDAO.addAccount();

//		close the context
		context.close();
	}

}
