package com.revature.repository;

import com.revature.model.Account;

public interface BankDao {

  //Read
  Account getBalance(Account user);
  
  //Update
  Account Withdraw(Account user);
  
  //Update
  Account Deposit(Account user);
  
  //Update
  void Transfer(Account give, Account take, Double amount);
  
  //Create user
  void register(Account newUser);
  
  //Delete
  void delete(Account user);
  
  
}
