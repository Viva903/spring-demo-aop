package com.viva903.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.viva903.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(getClass() + ": Doing my db work: adding an account");
	}
	
	public void addAccount(Account theAccount) {
		System.out.println(getClass() + ": With Param Account -> Doing my db work: adding an account");
	}
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + ": With Param Account, vipFlag -> Doing my db work: adding an account");
	}
	
	public boolean doWork() {
		
		System.out.println(getClass() + ": doWork()");
		return true;
	}
}
