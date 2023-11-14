package com.springapps.jpaexamples.accountapp;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public void transferMoney(Long fromAccountId, Long toAccountId, Integer sum) throws Exception{
        Account fromAccount = accountRepository.findById(fromAccountId).orElseThrow(() -> new EntityNotFoundException("from account not found"));
        Account toAccount = accountRepository.findById(toAccountId).orElseThrow(()->new EntityNotFoundException("to account not found"));

        toAccount.setBalance(toAccount.getBalance()+sum);
        accountRepository.save(toAccount);

        fromAccount.setBalance(fromAccount.getBalance()-sum);
        accountRepository.save(fromAccount);


    }


    @Transactional(rollbackFor = Exception.class)
    public void updateAccountBalance(Long accountId, Integer sum) throws Exception {
        Account fromAccount = accountRepository.findById(accountId).orElseThrow(()->new EntityNotFoundException("from account not found"));
        fromAccount.setBalance(sum);
        accountRepository.save(fromAccount);

    }
}
