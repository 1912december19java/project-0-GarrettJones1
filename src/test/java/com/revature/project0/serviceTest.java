package com.revature.project0;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//import org.junit.Before;

import com.revature.exception.OverdraftException;
import com.revature.exception.SuspiciousDepositException;
import com.revature.model.Account;
import com.revature.service.Service;

public class serviceTest {

	private static Account acc, acc1;

	@Before
	public void setUp() {
		acc = new Account("user", "pass", 100.00);
		acc1 = new Account("username","password",50.00);
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
	
	@Test
	public void testTransfer() {
		Service.Transfer(acc, acc1, 30.00);
		assertTrue(Service.CheckBalance(acc)==70.00);
	}

	@After
	public void tearDown() {
		acc = null;
	}

}
