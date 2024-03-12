package com.Banking_application.controller;


import java.util.List;
import java.util.Map;
//import org.hibernate.mapping.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Banking_application.dto.AccountDto;
import com.Banking_application.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	private AccountService accountService;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	//addacount rest api
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountdto)
	{
		System.out.println(accountdto);
		return new ResponseEntity<>(accountService.createAccount(accountdto),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
		AccountDto accountdto=accountService.getAccountById(id);
		return ResponseEntity.ok(accountdto);
		
	}
	@PutMapping("/{id}/deposit")
	public  ResponseEntity<AccountDto> deposite(@PathVariable Long id,@RequestBody Map<String,Double> request)
	{
		Double amount=request.get("amount");
		AccountDto accountdto=accountService.deposit(id,amount);
		return ResponseEntity.ok(accountdto);
		
	}
	
	@PutMapping("/{id}/withdraw")
	public  ResponseEntity<AccountDto> withdraw(@PathVariable Long id,@RequestBody Map<String,Double> request)
	{
		Double amount=request.get("amount");
		AccountDto accountdto=accountService.withdraw(id,amount);
		return ResponseEntity.ok(accountdto);
		
	}
	
	
	@GetMapping             
	public ResponseEntity<List<AccountDto>> getAllAccount(){
		List<AccountDto> accountdto=accountService.getAllAccount();
		return ResponseEntity.ok(accountdto);

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteAccount(@PathVariable Long id){
		accountService.deleteAccount(id);
		
		return ResponseEntity.ok(" Id Number "+id +" Account deleted Successfully..");

		
	}
	
	
	
}
