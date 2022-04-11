package com.br.letscode.databaseproject.account.repository;

import com.br.letscode.databaseproject.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "SELECT CASE  WHEN count(a)> 0 THEN true ELSE false END FROM Account a " +
            "WHERE a.number = :number AND a.agency = :agency")
    boolean existAccountWithNumberAndAgency(@Param("number") Integer number, @Param("agency") Integer agency);
}
