package com.viva903.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.viva903.aopdemo.dao.AccountDAO;
import com.viva903.aopdemo.dao.MembershipDAO;

public class MainApp {

	public static void main(String[] args) {

//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

//		get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

//		call the business method
		theAccountDAO.addAccount();
		
		Account myAccount = new Account();
		myAccount.setLevel("Platinum");
		myAccount.setName("Ronaldo");
		
		theAccountDAO.setName("ABC");
		theAccountDAO.setServiceCode("ABC code");
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();
		theAccountDAO.addAccount(myAccount);
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		theMembershipDAO.addMember();
		theMembershipDAO.goToSleep();
		
//		close the context
		context.close();
	}

}
