package com.revature.repository;

import com.revature.model.Account;

public interface BankDao {
  // Verify user and return an Account object to be used by the service class
  Account VerifyUser(String username, String password);

  // Persist data to the database
  void update(Account user);

  // Create user
  Account register(Account newUser);

  // Delete
  void delete(String username, String password);

  void TransactionLog(int id, double d);
  
  void showHistory(Account user);
}
