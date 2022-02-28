package com.eteration.simplebanking.repository;

import com.eteration.simplebanking.repository.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends MongoRepository<Account,String> {

    Optional<Account> findByAccountNumber(String accountNumber);

}
