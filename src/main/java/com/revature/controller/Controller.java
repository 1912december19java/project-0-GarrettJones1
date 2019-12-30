package com.revature.controller;

import java.util.Scanner;

import com.revature.service.Service;
import com.revature.model.Account;

public class Controller {

	public static void UI(Account user) {

		Scanner sc = new Scanner(System.in);
		String input;

		do {
			System.out.println("\nPlease choose your prefered Operation : Check Balance, Withdraw, or Deposit");
			System.out.println("Or enter 'quit' to quit");

			input = sc.nextLine();

			switch (input.toLowerCase()) {
			case ("check balance"): {
				Service.CheckBalance(user);
				break;
			}
			case ("withdraw"): {
				System.out.print("Please enter the amount to be withdrawn : ");
				Double amount = sc.nextDouble();
				Service.Withdrawal(user, amount);
				break;
			}
			case ("deposit"): {
				System.out.print("Please enter the amount to be deposited : ");
				Double amount = sc.nextDouble();
				Service.Deposit(user, amount);
				break;
			}
			case ("quit"): {
				System.out.println("Exiting User Interface.");
				break;
			}
			default: {
				System.out.println("Unrecognized command, please enter another.\n");
				break;
			}
			}

		} while (!input.equalsIgnoreCase("quit"));

		sc.close();
	}
}
