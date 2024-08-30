package com.CheckingAcc.checkingacc.repository;

import com.CheckingAcc.checkingacc.Entity.CheckingAccount;
import com.CheckingAcc.checkingacc.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount,Long> {
    List<CheckingAccount> findByUser(User user);
    Optional<CheckingAccount> findByUserId(Long userId);
}
