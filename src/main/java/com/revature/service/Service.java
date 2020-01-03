package com.revature.service;

import org.apache.log4j.Logger;
import com.revature.exception.*;
import com.revature.model.Account;
import com.revature.repository.BankDao;
import com.revature.repository.BankDaoPostgres;

public class Service {

  private static Logger log = Logger.getLogger(Service.class);
  static BankDao bankdao = new BankDaoPostgres();

  /*
   * Accepts a user identification and prints the current balance
   */
  public static Double CheckBalance(Account user) {

    // Double amount = user.getAmount();

    System.out.println("The current balance for user " + user.getUsername() + " is : $"
        + user.getAmount() + " dollars.\n");

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
      System.out.println("\n" + amount + " dollars have been withdrawn from "+user.getUsername());

      // Double balance = user.getAmount();

      user.setAmount((user.getAmount() - amount));

      bankdao.update(user);
      bankdao.TransactionLog(user.getId(), (amount * -1));
      
      Service.CheckBalance(user);

    } catch (OverdraftException e) {
      e.printStackTrace();
    }
    log.info("Withdrew " + amount + " from account : " + user.getUsername());
    return user.getAmount();
  }

  /*
   * Adds the parameter amount to a specified user Throws OverdraftException
   */
  public static Double Deposit(Account user, Double amount) {
    try {
      if (amount < 0.0) {
        throw new NegativeDepositException();
      }
      System.out.println(amount + " dollars have been added to account "+user.getUsername());

      // Double balance = user.getAmount();
      user.setAmount(user.getAmount() + amount);

      bankdao.update(user);
      bankdao.TransactionLog(user.getId(), amount);

      Service.CheckBalance(user);

    } catch (NegativeDepositException e) {
      e.printStackTrace();
    }
    log.info("Deposited " + amount + " from account : " + user.getUsername());
    return user.getAmount();
  }

  /*
   * Transfers an amount from give to take Throws Overdraft Exception, InvalidDestination Exception
   */
  public static void Transfer(Account give, String username, String password, Double amount) {

    Account take = bankdao.VerifyUser(username, password);

    Withdrawal(give, amount);
    Deposit(take, amount);
    CheckBalance(give);
    CheckBalance(take);
  }

  public static void showHistory(Account user) {
    bankdao.showHistory(user);
  }
}
