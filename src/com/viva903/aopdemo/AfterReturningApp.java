package com.viva903.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.viva903.aopdemo.dao.AccountDAO;

public class AfterReturningApp {

	public static void main(String[] args) {

//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

//		get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> theListOfAccounts = theAccountDAO.findAccounts();
		
//		display the accounts
		System.out.println("\n\nMain Program: AfterReturningApp");
		System.out.println("----");
		System.out.println(theListOfAccounts + "\n");
		
//		close the context
		context.close();
	}

}
