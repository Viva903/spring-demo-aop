package com.viva903.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {

//		simulate a delay
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "Heavy Traffice this morning !!";
	}

	public String getFortune(boolean tripWire) {

		if (tripWire) {
			throw new RuntimeException("Major Accident!!!!!");
		}
		return getFortune();
	}
}
