package com.revature.model;

public class Account {

  private int id;
  private String username;
  private String password;
  private Double amount;

  public Account(int id, Double amount) {
    super();
    this.id = id;
    this.amount = amount;
  }

  public Account(int id, String username, String password, Double amount) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.amount = amount;
  }

  public Account(String username, String password, Double amount) {
    super();
    this.username = username;
    this.password = password;
    this.amount = amount;

  }


  // Begin getters and setters

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  // End getters and setters
}
