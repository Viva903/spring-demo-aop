package com.viva903.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
//	this is where you will add all the related advices for logging
//	let's start with an @Before Advice
	
	@Pointcut("execution(* com.viva903.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
//	@Before("execution(public void com.viva903.aopdemo.DAO.AccountDAO.addAccount())")
//	@Before("execution(public void com.viva903.aopdemo.DAO.MembershipDAO.addAccount())")
//	@Before("execution(public void addAccount())")
//	@Before("execution(public void add*())")
//	@Before("execution(void add*())")
//	@Before("execution(* add*(com.viva903.aopdemo.Account))")
//	@Before("execution(* add*(Account))") -> no match for this type name, must give full qualified class
//	@Before("execution(* add*(com.viva903.aopdemo.Account, ..))")
//	@Before("execution(* add*(..))")com.viva903.aopdemo.dao
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=========>>>> Execution @Before advice");
	}
	
	@Before("forDaoPackage()")
	public void performAPIAnalytics() {
		
		System.out.println("\n=========>>>> Perform API Analytics");
	}
}
