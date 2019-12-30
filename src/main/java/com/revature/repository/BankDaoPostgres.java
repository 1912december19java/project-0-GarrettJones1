package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.model.Account;

public class BankDaoPostgres implements BankDao {


  public Account getBalance(Account user) {
    // TODO Auto-generated method stub
    return null;
  }


  public Account Withdraw(Account user) {
    // TODO Auto-generated method stub
    return null;
  }


  public Account Deposit(Account user) {
    // TODO Auto-generated method stub
    return null;
  }


  public void Transfer(Account give, Account take, Double amount) {
    // TODO Auto-generated method stub

  }


  public void register(Account newUser) {
    // TODO Auto-generated method stub

  }


  public void delete(Account user) {
    // TODO Auto-generated method stub

  }

}
