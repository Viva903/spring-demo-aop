package com.viva903.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MyApiAnalyticsAspect {


	@Before("com.viva903.aopdemo.aspect.AopExpressions.methodWithoutGetterSetter()")
	public void performAPIAnalytics() {

		System.out.println("\n=========>>>> Perform API Analytics");
	}
}
