package com.eteration.simplebanking.services;

import com.eteration.simplebanking.dto.request.AccountRequestDto;
import com.eteration.simplebanking.dto.response.AccountResponseDto;
import com.eteration.simplebanking.dto.response.TransactionStatus;
import com.eteration.simplebanking.exception.InsufficientBalanceException;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.repository.AccountRepository;
import com.eteration.simplebanking.repository.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    MapperService mapperService;

    public Account saveAccount(AccountRequestDto accountRequestDto){
        Account account = mapperService.accountMapper(accountRequestDto);
       return accountRepository.save(account);
    }

    public Account updateAccount(Account account){
       return accountRepository.save(account);
    }

    public void deleteAccount(Account account){
       accountRepository.delete(account);
    }

    public List<Account> findAllAccounts(){
      return  accountRepository.findAll();
    }

    public Account findAccountByAccountNumber(String accountNumber){
        Optional<Account> accountOpt = accountRepository.findByAccountNumber(accountNumber);
        if(accountOpt.isPresent()){
            return accountOpt.get();
        }else {
            return null;
        }
    }

    public AccountResponseDto findAccountByAccountNumberResponse(String accountNumber){
        Optional<Account> accountOpt = accountRepository.findByAccountNumber(accountNumber);
        if(accountOpt.isPresent()){
            return mapperService.accountResponseDtoMapper(accountOpt.get());
        }else {
            return null;
        }
    }

    public TransactionStatus credit(String accountNumber, double amount){
        Account account = findAccountByAccountNumber(accountNumber);
        Transaction transaction = new DepositTransaction(amount);
        account.setBalance(account.getBalance() + amount);
        account.getTransactions().add(transaction);
        updateAccount(account);
        TransactionStatus status = TransactionStatus.builder().
                description("Transaction completed successfully").
                updatedBalance(account.getBalance()).
                transactionType(transaction.getType()).
                transactionAmount(amount).
                build();
        return status;
    }

    public TransactionStatus debit(String accountNumber, double amount){
        Account account = findAccountByAccountNumber(accountNumber);
        Transaction transaction = new WithdrawalTransaction(amount);
        if(account.getBalance() > 0 && account.getBalance() >= amount){
            account.setBalance(account.getBalance() - amount);
            account.getTransactions().add(transaction);
            updateAccount(account);
            TransactionStatus status = TransactionStatus.builder().
                    description("Transaction completed successfully").
                    updatedBalance(account.getBalance()).
                    transactionType(transaction.getType()).
                    transactionAmount(amount)
                    .build();
            return status;
        }else{
            throw new InsufficientBalanceException();
        }
    }

}
