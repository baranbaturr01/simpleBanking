package com.eteration.simplebanking.model;


import java.util.Date;
import java.util.List;

// This class is a place holder you can change the complete implementation
public abstract class Transaction {

    private double amount;
    private Account account;

    private Date date;

    public Transaction(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public abstract void execute() throws InsufficientBalanceException;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
