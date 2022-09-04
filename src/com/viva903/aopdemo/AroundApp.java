package com.viva903.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.viva903.aopdemo.service.TrafficFortuneService;

public class AroundApp {

	private static Logger mylogger = Logger.getLogger(AroundApp.class.getName());
	
	public static void main(String[] args) {
//		read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
//		retrieve required beans from the context
		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		mylogger.info("\nMain Program: @Around App");
		mylogger.info("Calling getFortune()");
		
		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		mylogger.info("\nMy fortune is: " + data);
		
		mylogger.info("Finished");
	}

}
