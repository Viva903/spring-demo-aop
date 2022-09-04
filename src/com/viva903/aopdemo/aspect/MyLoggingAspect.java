package com.viva903.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.viva903.aopdemo.Account;
import com.viva903.aopdemo.AroundApp;

@Aspect
@Component
@Order(-1)
public class MyLoggingAspect {
	
	private Logger mylogger = Logger.getLogger(getClass().getName());
	
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

		mylogger.info("\n=========>>>> Execution @Before advice");

//		display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		mylogger.info("Method Signature : " + methodSignature);
//		display the method arguments
		Object[] args = theJoinPoint.getArgs();
		for (Object tempArg : args) {
			mylogger.info("Method arguments : " + tempArg);
			if (tempArg instanceof Account) {

				// downcast and print Account object specific stuff
				Account account = (Account) tempArg;
				mylogger.info("account name : " + account.getName());
				mylogger.info("account level : " + account.getLevel());
			}
		}

	}

	@AfterReturning(pointcut = "execution(* com.viva903.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

//		print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		mylogger.info("\n==========>>>>>>>> Executing @AfterReturning method : " + method);

//		print out the results of the method call
		mylogger.info("\n==========>>>>>>>> Result is : " + result);

//		post process data and modify

//		convert the account names to uppercase
		convertAccountNamesToUpperCase(result);

//		print out the results of the method call
		mylogger.info("\n==========>>>>>>>> Result is : " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
//		loop through account
//		get uppercase version of name
//		update the name to the respective account

		for (Account tempAccount : result) {
			String toUpperCaseName = tempAccount.getName().toUpperCase();
			tempAccount.setName(toUpperCaseName);
		}

	}

	@AfterThrowing(pointcut = "execution(* com.viva903.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "e")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable e) {
//		print out which method we are advising on 
//		log the exception
		String methodSignature = theJoinPoint.getSignature().toShortString();
		mylogger.info("\n==========>>>>>>>> Executing @AfterThrowing method : " + methodSignature);

		mylogger.info("\n==========>>>>>>>> Logged Exception is : " + e);

	}

	@After("execution(* com.viva903.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		String methodSignature = theJoinPoint.getSignature().toShortString();
		mylogger.info("\n==========>>>>>>>> Executing @After(finally) method : " + methodSignature);
	}

	@Around("execution(* com.viva903.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortuneService(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		String methodSignature = theProceedingJoinPoint.getSignature().toShortString();
		mylogger.info("\n==========>>>>>>>> Executing @Around method : " + methodSignature);
		
//		get begin time stamp
		long begin = System.currentTimeMillis();
//		execute the method
		Object result = theProceedingJoinPoint.proceed();
//		get end time stamp
		long end = System.currentTimeMillis();
//		print out the time difference
		long duration = end - begin;
		mylogger.info("\n==========>>>>>>>> Duration + " + duration / 1000.0 + " second(s)");
		
		return result;
	}

}
