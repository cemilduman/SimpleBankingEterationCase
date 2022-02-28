package com.eteration.simplebanking.services;

import com.eteration.simplebanking.dto.request.AccountRequestDto;
import com.eteration.simplebanking.dto.response.AccountResponseDto;
import com.eteration.simplebanking.dto.response.TransactionResponseDto;
import com.eteration.simplebanking.repository.entity.Account;
import com.eteration.simplebanking.model.Transaction;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MapperService {

    public AccountResponseDto accountResponseDtoMapper(Account account){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        AccountResponseDto accountResponseDto = new AccountResponseDto();
        accountResponseDto.setAccountNumber(account.getAccountNumber());
        accountResponseDto.setBalance(account.getBalance());
        accountResponseDto.setOwner(account.getOwner());
        for(Transaction transaction : account.getTransactions()){
            TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
            transactionResponseDto.setType(transaction.getType());
            transactionResponseDto.setAmount(transaction.getAmount());
            transactionResponseDto.setApprovalCode(transaction.getApprovalCode());
            transactionResponseDto.setDate(formatter.format(new Date(transaction.getDate())));
            accountResponseDto.getTransactions().add(transactionResponseDto);
        }
        return accountResponseDto;
    }

    public Account accountMapper(AccountRequestDto accountRequsetDto){
        Account account = new Account();
        account.setOwner(accountRequsetDto.getOwner());
        account.setAccountNumber(accountRequsetDto.getAccountNumber());
        return account;
    }
}
