package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This class is a place holder you can change the complete implementation
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public ResponseEntity<TransactionStatus> credit(String accountId, DepositTransaction transaction) {
        Account account = accountService.findAccount(accountId);
        transaction.setAccount(account);
        transaction.execute();
        return ResponseEntity.ok(new TransactionStatus("OK"));
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccount(String accountNumber) {
        Account account = accountService.findAccount(accountNumber);
        return ResponseEntity.ok(account);
    }

    public ResponseEntity<TransactionStatus> debit(String accountId, WithdrawalTransaction transaction) throws InsufficientBalanceException {
        Account account = accountService.findAccount(accountId);
        transaction.setAccount(account);
        transaction.execute();
        return ResponseEntity.ok(new TransactionStatus("OK"));
    }
}