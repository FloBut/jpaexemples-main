package com.springapps.jpaexamples.accountapp;

import com.springapps.jpaexamples.orderapp.Order;
import com.springapps.jpaexamples.orderapp.OrderRepository;
import com.springapps.jpaexamples.orderapp.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
// clasa Runner implementeaza interfata CommandLinner
// deci si metoda  run
@Component
public class Runner implements CommandLineRunner {
    // imi trebuie un accountService pentru ca de aici voi folosi metoda
    //transferMoney pe care vreau sa o testez
    AccountService accountService;
    // injectez been-ul accountService prin constructor
    @Autowired
    public Runner(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {

        accountService.transferMoney(1L,2L,10);
        //accountService.updateAccountBalance(1L, 1000);
    }
}
