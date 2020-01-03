package com.revature.project0;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
// import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
// import org.junit.Before;
import com.revature.model.Account;
import com.revature.service.Service;

public class serviceTest {

  private static Account acc;

  @Before
  public void setUp() {
    acc = new Account("user", "pass", 100.00);
  }

  @Test
  public void testCheckBalance() {
    assertTrue(Service.CheckBalance(acc) == 100.00);
  }

  @Test
  public void testDeposit() {
    assertTrue(Service.Deposit(acc, 20.00) == 120.00);
  }

  @Test
  public void testWithdrawal() {
    assertTrue(Service.Withdrawal(acc, 20.00) == 80.00);
  }

  @After
  public void tearDown() {
    acc = null;
  }

}
