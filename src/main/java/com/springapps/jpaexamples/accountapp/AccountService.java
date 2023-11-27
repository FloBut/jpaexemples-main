package com.springapps.jpaexamples.accountapp;
//in clasa aceasta fac logica aplicatiei
//iau banii dintr un cont si ii adaug in alt cont
//
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Ca si diferente intre adnotari:
//
//- @Bean este folosita pe metode, iar @Component este folosita pe clase
//- @Bean trebuie e folosita doar in clasele adnotate cu @Configuration
//- daca vrei sa creezi un bean dintr-o clasa care este intr-o librarie externa,
// nu poti folosi @Component, pentru ca nu poti modifica clasa.
// Atunci vei folosi @Bean
//- componentele se specializeaza chiar si mai mult. Spre exemplu, exista:
//- @Service - este o componenta pentru crearea serviciilor din aplicatie
//- @Repository - este o componenta care interactioneaza cu o baza de date sau un fisier
//O componenta este tot un bean, doar ca nu
// rezulta dintr-o metoda (ca la bean-uri), ci componenta este o intreaga clasa.
@Service// este o componenta in care se creaza serviciile din aplicatie
//
public class AccountService {
    // accountRepository este been-ul care imi permite
    // sa fac operatii cu baza de date
    //de aceea il injectez in accountService ca sa ii pot folosi
    //functionalitatile in accountService
    private AccountRepository accountRepository;

    //Putem folosi `@Autowired` pentru a injecta
    // o dependinta prin constructor si setter
    //In plus, putem sa pune @Autowired si direct pe un atribut
    // al unei clase, iar spring va stii sa injecteze dependinta.

    @Autowired//injectam dependinta prin constructor
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    // daca o operatie nu se efectueaza atunci nu se mai efectueaza nici o operatie si face roollBackFor
    //metoda transfera bani din contul cu Id indicat in alt cont cu un Id si suma de bani
    // pe care urmeaza sa o transfer
    public void transferMoney(Long fromAccountId, Long toAccountId, Integer sum) throws Exception{
        // din contul fromAccount ma folosesc de metoda findById care imi returneaza un optional si arunc exceptie
        Account fromAccount = accountRepository.findById(fromAccountId).orElseThrow(() -> new EntityNotFoundException("from account not found"));
        // in contul toAccount ma folosesc de metoda findById care imi returneaza un optional si arunc exceptie
        Account toAccount = accountRepository.findById(toAccountId).orElseThrow(()->new EntityNotFoundException("to account not found"));
        //acum am cele doua conturi din baza de date aduse din memoria java
        //si setez contul in care vreau sa adaug cu suma pe care vreau sa o depun
        toAccount.setBalance(toAccount.getBalance()+sum);
        //salvez cu ajutorul been-ului  in baza de date valoarea contului
        // in care am pus bani
        accountRepository.save(toAccount);
        //modific contul din care am luat bani
        fromAccount.setBalance(fromAccount.getBalance()-sum);
        //salvez in baza de date contul din care am luat bani
        accountRepository.save(fromAccount);


    }


    @Transactional(rollbackFor = Exception.class)
    public void updateAccountBalance(Long accountId, Integer sum) throws Exception {
        Account fromAccount = accountRepository.findById(accountId).orElseThrow(()->new EntityNotFoundException("from account not found"));
        fromAccount.setBalance(sum);
        accountRepository.save(fromAccount);

    }
}
