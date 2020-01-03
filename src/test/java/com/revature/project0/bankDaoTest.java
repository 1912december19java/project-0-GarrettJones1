package com.revature.project0;
/*
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.revature.model.Account;
import com.revature.repository.BankDao;
import com.revature.repository.BankDaoPostgres;
*/
public class bankDaoTest {
  
  //NonFunctional
/*
  private static Account acc;
  private static BankDao bankdao = new BankDaoPostgres();
  private static Connection conn;


  @Before
  public void SetUp() {
    try {
      conn = DriverManager.getConnection(System.getenv("connString"), System.getenv("username"),
          System.getenv("password"));
    } catch (

    SQLException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testVerifyUser() {
    acc = bankdao.VerifyUser("JohnDoe", "password");
    assertTrue(acc.getUsername().equals("JohnDoe") && acc.getPassword().equals("password"));
  }
*/
}
