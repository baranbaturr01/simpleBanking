package com.eteration.simplebanking.model;


// This class is a place holder you can change the complete implementation

import java.util.Collection;


//entity olarak tanımlayacaktım ancak projeyi idrak edemedim ve bu şekilde yaptım.
public class Account {

    private int id;
    private String accountNumber;

    private String customerName;
    private double balance;

    private Collection<Transaction> transactions;

    public Account(String accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public Account(String customerName, String accountNumber) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
    }

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account() {

    }

    private int getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Collection<Transaction> getTransactions() {
        return transactions;
    }

    public String getOwner() {
        return customerName;
    }

    public void post(WithdrawalTransaction depositTrx) throws InsufficientBalanceException {
        depositTrx.execute();
        addTransaction(depositTrx);
    }

    public void post(DepositTransaction depositTrx) {
        depositTrx.execute();
        addTransaction(depositTrx);
    }
}
