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
	public static Double CheckBalance(Account user) {
		System.out.println(
				"The current balance for user " + user.getUsername() + " is : " + user.getAmount() + " dollars.");

		return user.getAmount();
	}

	/*
	 * Subtracts parameter amount from specified user Throws OverdraftException
	 */
	public static Double Withdrawal(Account user, Double amount) {
		try {
			if (user.getAmount() - amount < 0.0) {
				throw new OverdraftException();
			}
			System.out.println("\n" + amount + " dollars have been withdrawn.");

			user.setAmount((user.getAmount() - amount));

		} catch (OverdraftException e) {

		}
		System.out.println("Your account balance is " + user.getAmount());
		return user.getAmount();
	}

	/*
	 * Adds the parameter amount to a specified user Throws OverdraftException
	 */
	public static Double Deposit(Account user, Double amount) {
		try {
			if (amount > 50000.0) {
				throw new SuspiciousDepositException();
			}
			System.out.println(amount + " dollars have been added to your account.");
			user.setAmount(user.getAmount() + amount);
			;
		} catch (SuspiciousDepositException e) {

		}
		System.out.print("Your account balance is : " + user.getAmount());
		return user.getAmount();
	}

	/*
	 * Transfers an amount from give to take Throws Overdraft Exception,
	 * InvalidDestination Exception
	 */
	public static Double Transfer(Account give, Account take, Double amount) {
		try {
			if (take.getUsername() == "username") {
			} else {
				throw new InvalidUserException();
			}
		} catch (InvalidUserException e) {
		}

		Withdrawal(give, amount);
		Deposit(take, amount);
		CheckBalance(give);
		CheckBalance(take);

		return give.getAmount();
	}
}
