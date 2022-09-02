package com.viva903.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.viva903.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public List<Account> findAccounts(boolean tripWire) {
		
		 if (tripWire) {
			 throw new RuntimeException("No Soup for you !!");
		 }
		
		 List<Account> myAccounts = new ArrayList<>();
		 Account tempAcc1 = new Account("Davide", "Gold");
		 Account tempAcc2 = new Account("Lisandro", "Platinum");
		 Account tempAcc3 = new Account("Luca", "Titanium");
		 
		 myAccounts.add(tempAcc1);
		 myAccounts.add(tempAcc2);
		 myAccounts.add(tempAcc3);
		 return myAccounts;
	}

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
