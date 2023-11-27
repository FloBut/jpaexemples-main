package com.springapps.jpaexamples.accountapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// o interfata care extinde interfata java persistance api
// care creeaza un been care ma va ajuta sa implemenyez metodele de crud si nu numi
@Repository // ii spune Spring-ului sa creeze un bean,
// pentru a putea accesa metodele de crud pentru un order.
// long este tipul Id
public interface AccountRepository extends JpaRepository<Account, Long> {
}
