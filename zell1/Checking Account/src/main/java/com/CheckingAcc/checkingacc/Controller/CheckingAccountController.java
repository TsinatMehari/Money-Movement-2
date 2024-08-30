package com.CheckingAcc.checkingacc.Controller;

import com.CheckingAcc.checkingacc.Entity.CheckingAccount;
import com.CheckingAcc.checkingacc.Entity.User;
import com.CheckingAcc.checkingacc.Service.CheckingAccountService;
import com.CheckingAcc.checkingacc.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class CheckingAccountController {
    @Autowired
    private CheckingAccountService checkingAccountService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<CheckingAccount> createAccount(@RequestParam Long userId) {
        User user = userService.findUserById(userId);
        CheckingAccount account = checkingAccountService.createAccount(user);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/deposit")
    public ResponseEntity<CheckingAccount> deposit(@RequestParam Long accountId, @RequestParam double amount) {
        CheckingAccount account = checkingAccountService.deposit(accountId, amount);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<CheckingAccount> withdraw(@RequestParam Long accountId, @RequestParam double amount) {
        CheckingAccount account = checkingAccountService.withdraw(accountId, amount);
        return ResponseEntity.ok(account);
    }

}
