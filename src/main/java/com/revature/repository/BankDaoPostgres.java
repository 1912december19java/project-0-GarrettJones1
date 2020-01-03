package com.revature.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;
import com.revature.model.Account;

public class BankDaoPostgres implements BankDao {

  private static Connection conn;
  private static Logger log = Logger.getLogger(BankDaoPostgres.class);

  /*
   * How to use Logger log.trace("String message"); log.info("String message");
   */

  // This will run when the class loads, after static fields are initialized.
  static {
    try {
      conn = DriverManager.getConnection(System.getenv("connString"), System.getenv("username"),
          System.getenv("password"));
      log.info("Connected to the Database");
    } catch (SQLException e) {
      log.error("Failed to connect to the database.");
      e.printStackTrace();
    }
  }

  public Account VerifyUser(String username, String password) {
    Account user = null;

    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
      stmt = conn.prepareStatement(
          "SELECT id, username, pass, balance FROM Account WHERE username = ? AND pass = ?");
      // ? is index 1
      stmt.setString(1, username);
      stmt.setString(2, password);
      // Now our statement is ready to go. Lets run it.
      if (stmt.execute()) {
        // Now we likely have results. Lets get them.
        rs = stmt.getResultSet();
      }
      rs.next();

      user = new Account(rs.getInt("id"), rs.getString("username"), rs.getString("pass"),
          rs.getDouble("balance"));
      log.info("Verifed User, continuing execution");
    } catch (SQLException e) {
      log.error("Failed to Validate User");
      e.printStackTrace();
    }

    return user;
  }

  public void update(Account user) {
    PreparedStatement stmt = null;
    try {
      stmt = conn.prepareStatement("UPDATE Account SET balance = ? WHERE id = ?");
      // ? is index 1
      stmt.setDouble(1, user.getAmount());
      stmt.setInt(2, user.getId());

      stmt.execute();
      log.info("Updated Account for username : " + user.getUsername());

    } catch (SQLException e) {
      log.error("Failed to Update Account.");
      e.printStackTrace();
    }
  }

  public Account register(Account newUser) {

    PreparedStatement stmt = null;
    Account acc = null;

    try {
      stmt = conn.prepareStatement("INSERT INTO Account(balance, username, pass) VALUES (?,?,?)");
      // ? is index 1
      stmt.setDouble(1, newUser.getAmount());
      stmt.setString(2, newUser.getUsername());
      stmt.setString(3, newUser.getPassword());

      stmt.execute();

      acc = VerifyUser(newUser.getUsername(), newUser.getPassword());
      log.info("Created new user with an ID of : " + acc.getId());
    } catch (SQLException e) {
      System.out.println("Username is already taken.");
      log.error("Failed to Register new account.");
      e.printStackTrace();
    }
    return acc;
  }


  public void delete(String username, String password) {

    PreparedStatement stmt = null;
    try {
      stmt = conn.prepareStatement("DELETE FROM Account WHERE username = ? AND pass = ?");
      // ? is index 1
      stmt.setString(1, username);
      stmt.setString(2, password);

      stmt.execute();
      log.info("Deleted user where username = " + username);
    } catch (SQLException e) {
      log.error("Failed to Delete user.");
      e.printStackTrace();
    }
  }

  public void TransactionLog(int id, double amount) {
    PreparedStatement stmt = null;

    try {
      stmt = conn.prepareStatement("INSERT INTO History(account_id, amount) VALUES (?,?)");
      stmt.setInt(1, id);
      stmt.setDouble(2, amount);

      stmt.execute();
      log.info("Updated transaction history.");
    } catch (SQLException e) {
      log.error("Failed to update transaction history.");
    }
  }

  public void showHistory(Account user) {
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
      stmt = conn.prepareStatement("SELECT * FROM History WHERE account_id = ?");
      stmt.setInt(1, user.getId());

      if (stmt.execute()) {
        rs = stmt.getResultSet();
      }
      rs.next();
      System.out.println("Logged Transactions \n");
      while (rs.next()) {
        System.out.println("Transaction Number = " + rs.getInt("id") + ", Amount = "
            + rs.getDouble("amount") + ", Timestamp = " + rs.getTimestamp("time"));
      }

      log.info("Updated transaction history.");
    } catch (SQLException e) {
      log.error("Failed to update transaction history.");
    }

  }

}
