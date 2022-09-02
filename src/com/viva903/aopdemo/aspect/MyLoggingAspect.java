package com.viva903.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.viva903.aopdemo.Account;

@Aspect
@Component
@Order(-1)
public class MyLoggingAspect {
//	this is where you will add all the related advices for logging
//	let's start with an @Before Advice

//	@Before("execution(public void com.viva903.aopdemo.DAO.AccountDAO.addAccount())")
//	@Before("execution(public void com.viva903.aopdemo.DAO.MembershipDAO.addAccount())")
//	@Before("execution(public void addAccount())")
//	@Before("execution(public void add*())")
//	@Before("execution(void add*())")
//	@Before("execution(* add*(com.viva903.aopdemo.Account))")
//	@Before("execution(* add*(Account))") -> no match for this type name, must give full qualified class
//	@Before("execution(* add*(com.viva903.aopdemo.Account, ..))")
//	@Before("execution(* add*(..))")com.viva903.aopdemo.dao
	@Before("com.viva903.aopdemo.aspect.AopExpressions.methodWithoutGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

		System.out.println("\n=========>>>> Execution @Before advice");

//		display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method Signature : " + methodSignature);
//		display the method arguments
		Object[] args = theJoinPoint.getArgs();
		for (Object tempArg :args) {
			System.out.println("Method arguments : " + tempArg);
			if (tempArg instanceof Account) {
				
				//downcast and print Account object specific stuff
				Account account = (Account) tempArg;
				System.out.println("account name : " + account.getName());
				System.out.println("account level : " + account.getLevel());
			}
		}
		
	}

}
