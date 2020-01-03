package com.revature.controller;

import java.util.Scanner;
import com.revature.service.Service;
import com.revature.model.Account;
import com.revature.repository.BankDao;
import com.revature.repository.BankDaoPostgres;

public class Controller {

  static Scanner sc = new Scanner(System.in);

  public static Account LogIn() {

    Account user;
    BankDao bankdao = new BankDaoPostgres();
    String username, password, choice;
    Double amount;

    do {
      user = null;
      System.out
          .println("Would you like to Login, Register a new account, or Delete your account?");
      System.out.println("Or enter 'quit' to quit.");
      choice = sc.nextLine().toLowerCase();

      switch (choice) {
        case ("login"): {
          System.out.println("Please Log In\n");

          System.out.println("Please enter your Username : ");
          username = sc.nextLine();
          System.out.println("Please enter your Password : ");
          password = sc.nextLine();

          user = bankdao.VerifyUser(username, password);
          UI(user);
          break;
        }
        case ("register"): {

          System.out.println(
              "Please enter a username, password, and initial deposit to register account\n");

          System.out.println("Enter username : ");
          username = sc.nextLine();
          System.out.println("Enter password : ");
          password = sc.nextLine();
          System.out.println("Enter initial deposit amount : ");
          amount = sc.nextDouble();

          user = new Account(username, password, amount);

          user = bankdao.register(user);
          UI(user);
          break;
        }
        case ("delete"): {
          System.out.println("Please enter credentials of account to delete\n");

          System.out.println("Please enter your Username : ");
          username = sc.nextLine();
          System.out.println("Please enter your Password : ");
          password = sc.nextLine();

          bankdao.delete(username, password);
          break;
        }
        case ("quit"): {
          System.out.println("Exiting User Interface.");
          break;
        }
        default: {
          System.out.println("Invalid option please enter either, LogIn, Register, or Delete");
          break;
        }
      }
    } while (!choice.equalsIgnoreCase("quit"));
    sc.close();
    return user;
  }

  public static void UI(Account user) {

    String input;

    do {
      System.out.println(
          "\nPlease choose your prefered Operation : Check Balance, Withdraw, Deposit, Transfer, Report or LogOut");

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
        case ("transfer"): {
          System.out.println("Please enter the username of the account to transfer to :");
          String username = sc.nextLine();
          System.out.println("Please enter the password of the account to transfer into :");
          String password = sc.nextLine();
          System.out.println("Please enter the amount to be transfered :");
          Double amount = sc.nextDouble();
          
          Service.Transfer(user, username, password, amount);
          break;
        }
        case ("report"): {
          Service.showHistory(user);
          break;
        }
        case ("logout"): {
          System.out.println("Logging out.");
          break;
        }
        default: {
          System.out
              .println("Unrecognized command, please enter check balance, withdraw, or deposit.\n");
          break;
        }
      }

    } while (!input.equalsIgnoreCase("logout"));
  }
}
