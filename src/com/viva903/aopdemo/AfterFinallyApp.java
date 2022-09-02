package com.viva903.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.viva903.aopdemo.dao.AccountDAO;

public class AfterFinallyApp {

	public static void main(String[] args) {

//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

//		get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> theListOfAccounts = null;
		
		
		try {
//			add boolean flag to simulate exceptions
			boolean tripWire = true;
			theListOfAccounts =	theAccountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\n\nMain program .. caught exception " + e);
//			e.printStackTrace();
		}
		
//		display the accounts
		System.out.println("\n\nMain Program: AfterFinallyApp");
		System.out.println("----");
		System.out.println(theListOfAccounts + "\n");
		
//		close the context
		context.close();
	}

}
