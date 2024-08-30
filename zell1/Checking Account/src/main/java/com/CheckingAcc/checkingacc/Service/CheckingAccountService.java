package com.CheckingAcc.checkingacc.Service;

import com.CheckingAcc.checkingacc.Entity.CheckingAccount;
import com.CheckingAcc.checkingacc.Entity.User;
import com.CheckingAcc.checkingacc.Exception.UserException;
import com.CheckingAcc.checkingacc.repository.CheckingAccountRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckingAccountService {
    @Autowired
    private CheckingAccountRepository checkingAccountRepository;

    public CheckingAccount createAccount(User user) {
        CheckingAccount account = new CheckingAccount();
        account.setUser(user);
        account.setBalance(0.0);
        return checkingAccountRepository.save(account);
    }

    public CheckingAccount deposit(Long accountId, double amount) {
        CheckingAccount account = checkingAccountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        return checkingAccountRepository.save(account);
    }

    public CheckingAccount withdraw(Long accountId, double amount) {
        CheckingAccount account = checkingAccountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
        if (account.getBalance() < amount) {
            throw new UserException.InsufficientFundsException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        return checkingAccountRepository.save(account);
    }
}


