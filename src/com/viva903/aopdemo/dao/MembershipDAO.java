package com.viva903.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addMember() {
		System.out.println(getClass() + ": Doing my db work: adding an membership account");
		return true;
	}
	
	public void goToSleep() {
		
		System.out.println(getClass() + ": I am going to sleep now ... ");
	}
}
