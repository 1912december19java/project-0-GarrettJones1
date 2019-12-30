package com.revature;

import com.revature.controller.Controller;
import com.revature.model.Account;
import java.util.Scanner;

/**
 * Create an instance of your controller and launch your application.
 * 
 * Try not to have any logic at all on this class.
 */
public class Main {

  public static void main(String[] args) {

    // Implement Login and instantiate a User
    Account user = new Account("user", "pass", 100.00);
    System.out.println("Account created");
    // After passing Login, use controller to guide user threw the program
    System.out.println("controller created");

    Scanner sc = new Scanner(System.in);
    String input = "HelloWorld";

    do {

      // implement login functionality

      Controller.UI(user);

      System.out.println("\nWould you like to logIn as another User? y\n");
      input = sc.nextLine();

    } while (!input.equalsIgnoreCase("n"));
    System.out.println("Thank you for banking with us!");
    sc.close();
  }
}
