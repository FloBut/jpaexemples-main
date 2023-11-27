package com.springapps.jpaexamples.accountapp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity // se foloseste pentru a-i spune JPA-ului faptul ca acaesta clasa este o entitate.
//jpa - o clasa din Java este o entitate,
// care va avea ca si corespondent un tabel in baza de date.
public class Account {

    @Id //ca sa specifica id-ul entitatii, adica cheia primara din tabel
    @GeneratedValue // ne ajuta sa generam automat valori ale id-urilor,
    // pe masura ce adaugam date in baza de date, de obicei incrementeaza cu 1
    @Column(name = "order_id") // coloana care va avea numele order_id
    private long id;

    @Column
    private Integer balance;
    //fac constructorul gol deorece mai intai se creaza tabelul gol

    public Account(){}

    public Account(long id, Integer balance) {
        this.id = id;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long orderId) {
        this.id = orderId;
    }

    public Integer getBalance() {

        return balance;
    }

    public void setBalance(Integer balance) throws Exception{

        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "orderId=" + id +
                ", balance=" + balance +
                '}';
    }
}
