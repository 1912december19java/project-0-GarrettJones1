package com.revature.service;

import com.revature.exception.*;
import com.revature.model.Account;

public class Service {

	public Service() {
		super();
	}

	/*
	 * Accepts a user identification and prints the current balance
	 */
	public void CheckBalance(Account user) {
		System.out.println(
				"The current balance for user " + user.getUsername() + " is : " + user.getAmount() + " dollars.");
	}

	/*
	 * Subtracts parameter amount from specified user Throws OverdraftException
	 */
	public void Withdrawal(Account user, Double amount) throws OverdraftException {
		try {
			if (user.getAmount() - amount < 0.0) {
				throw new OverdraftException();
			}
			System.out.println(amount + " dollars have been withdrawn.");
			CheckBalance(user);
		} catch (OverdraftException e) {

		}
	}

	/*
	 * Adds the parameter amount to a specified user Throws OverdraftException
	 */
	public void Deposit(Account user, Double amount) throws SuspiciousDepositException {
		try {
			if (amount > 50000.0) {
				throw new SuspiciousDepositException();
			}
			System.out.println(amount + " dollars have been added to your account.");
			CheckBalance(user);
		} catch (SuspiciousDepositException e) {

		}
	}

	/*
	 * Transfers an amount from give to take Throws Overdraft Exception,
	 * InvalidDestination Exception
	 */
	public void Transfer(Account give, Account take, Double amount)
			throws OverdraftException, SuspiciousDepositException {

		try {
			Withdrawal(give, amount);
			Deposit(take, amount);
			CheckBalance(give);
			CheckBalance(take);
		} catch (OverdraftException e) {
			e.printStackTrace();
		} catch (SuspiciousDepositException e) {
			e.printStackTrace();
		}
	}
}
