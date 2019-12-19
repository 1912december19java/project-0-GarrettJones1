package com.revature.controller;

import java.util.Scanner;

import com.revature.service.Service;
import com.revature.exception.*;
import com.revature.model.Account;

public class Controller {

	public void UI(Account user) throws OverdraftException, SuspiciousDepositException {
		Scanner sc = new Scanner(System.in);
		String input;
		Service service = new Service();

		
		do {
			System.out.println("Please choose your prefered Operation : Check Balance, Withdrawal, or " + "Deposit");
			System.out.println("Or enter 'quit' to quit");

			input = sc.nextLine();
			input.toLowerCase();

			switch (input) {
			case ("check balance"): {
				service.CheckBalance(user);
				break;
			}
			case ("withdraw"): {
				System.out.print("Please enter the amount to be withdrawn : ");
				Double amount = sc.nextDouble();
				service.Withdrawal(user, amount);
				break;
			}
			case ("deposit"): {
				System.out.print("Please enter the amount to be deposited : ");
				Double amount = sc.nextDouble();
				service.Deposit(user, amount);
				break;
			}
			case ("quit"): {
				System.out.println("Exiting User Interface.");
				break;
			}
			default: {
				System.out.println("Unrecognized command, please enter another.\n");
			}
			}

		} while (!input.equalsIgnoreCase("quit"));
		sc.close();
	}
}
