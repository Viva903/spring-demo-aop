package com.viva903.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyCloudLogAsyncAspect {
	
	@Before("com.viva903.aopdemo.aspect.AopExpressions.methodWithoutGetterSetter()")
	public void logToCloudAsync() {
		
		System.out.println("\n=========>>>> loggin to Cloud in async fashion");
	}
	
}
