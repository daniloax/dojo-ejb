package org.jcb.dojo.ejb.server.atm;

import javax.ejb.Remote;

@Remote
public interface BankDatabase {
	
	public boolean authenticateUser(int userAccountNumber, int userPIN);
	public double getAvailableBalance(int userAccountNumber);
	public double getTotalBalance(int userAccountNumber);
	public void credit(int userAccountNumber, double amount);
	public void debit(int userAccountNumber, double amount);

}
