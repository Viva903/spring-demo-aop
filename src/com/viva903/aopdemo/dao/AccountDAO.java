package com.viva903.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.viva903.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;

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

	public String getName() {
		System.out.println(getClass() + ": getter getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setter setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": getter getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": setter setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
}
