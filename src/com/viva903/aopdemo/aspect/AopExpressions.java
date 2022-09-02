package com.viva903.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	@Pointcut("execution(* com.viva903.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {

	}

	@Pointcut("execution(* com.viva903.aopdemo.dao.*.get*())")
	public void getter() {

	}

	@Pointcut("execution(* com.viva903.aopdemo.dao.*.set*(*))")
	public void setter() {

	}

	@Pointcut("forDaoPackage() && !getter() && !setter()")
	public void methodWithoutGetterSetter() {

	}
	
}
