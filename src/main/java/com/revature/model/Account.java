package com.revature.model;

public class Account {

	private String username;
	private String password;
	private Double amount;

	public Account() {
		super();
	}

	public Account(String username, String password, Double amount) {
		super();
		this.username = username;
		this.password = password;
		this.amount = amount;

	}


	 //Begin getters and setters
	 
	 public String getUsername() { return username; }
	 
	 public void setUsername(String username) { this.username = username; }
	  
	 public String getPassword() { return password; }
	 
	 public void setPassword(String password) { this.password = password; }
	  
	 public Double getAmount() { return amount; }
	  
	 public void setAmount(Double amount) { this.amount = amount; }
	 
	 // End getters and setters
}
