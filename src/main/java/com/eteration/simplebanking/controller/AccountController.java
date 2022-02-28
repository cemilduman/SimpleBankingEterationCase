package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.dto.request.AccountRequestDto;
import com.eteration.simplebanking.dto.response.AccountResponseDto;
import com.eteration.simplebanking.dto.response.TransactionStatus;
import com.eteration.simplebanking.repository.entity.Account;
import com.eteration.simplebanking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static com.eteration.simplebanking.constant.RestApiURL.*;

@RestController
@RequestMapping(VERSION)
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping(SAVE)
    public ResponseEntity<Account> saveAccount(@RequestBody AccountRequestDto accountRequestDto){
        return ResponseEntity.ok(accountService.saveAccount(accountRequestDto));
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountResponseDto> getAccount(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.findAccountByAccountNumberResponse(accountNumber)) ;
    }

    @PostMapping(CREDIT+"/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable String accountNumber, @RequestParam double amount) {
        return ResponseEntity.ok(accountService.credit(accountNumber,amount));
    }

    @PostMapping(DEBIT+"/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable String accountNumber, @RequestParam double amount) {
        return ResponseEntity.ok(accountService.debit(accountNumber,amount));
	}

}