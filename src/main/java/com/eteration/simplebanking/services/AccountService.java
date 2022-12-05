package com.eteration.simplebanking.services;


import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// This class is a place holder you can change the complete implementation
@Service
public class AccountService {

//    private final AccountRepository accountRepository;
//
//    public AccountService(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }

    private AccountRepository accountRepository;
    public Account findAccount(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }
}
