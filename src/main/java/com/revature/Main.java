package com.revature;

import com.revature.controller.Controller;
import com.revature.exception.*;
import com.revature.model.Account;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */
public class Main {

	public static void main(String[] args) {

		//welcome message to be implemented after file input output
		/*
		try {
		File ascii = new File("c:/Users/mgjon/Documents/'Revature Notes'/banner.txt");
		Scanner scan = new Scanner(ascii);
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			System.out.println(line);
		}
		scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find file");
		}
		*/
		
		String repeat = "Yes";
		Scanner sc = new Scanner(System.in);
		
		while(!repeat.equalsIgnoreCase("quit")) {
		
		//Implement Login and instantiate a User
		Account user = new Account();
		System.out.println("Account created");
		//After passing Login, use controller to guide user threw the program
		Controller control = new Controller();
		System.out.println("controller created");
		try {
		control.UI(user);
		} catch (OverdraftException e){
			System.out.println("Overdraft Exception");
		} catch (SuspiciousDepositException e) {
			System.out.println("SuspiciousDepositException");
		}
		
		//Exit the Program
		System.out.println("\nNow exiting your account, thank you for banking with us, "
		+ user.getUsername() + "!");

		System.out.println("\nWould you like to log in as another user?\nenter quit to exit");
		repeat = sc.nextLine();
		}
		sc.close();
	}
}
