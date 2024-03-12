package com.Banking_application.mapper;

import com.Banking_application.dto.AccountDto;
import com.Banking_application.entity.Account;

public class AccountMapper {
	public static  Account mapToAccount(AccountDto accountdto) {
	
	Account account=new Account(
			
			accountdto.getId(),
			accountdto.getAccountHolderName(),
			accountdto.getBalance(),
			accountdto.getBank_name()
	
			
			
			
			
			);
	return account;
	}
	
	
	public static AccountDto mapToAccountDto(Account account)
	{
		AccountDto accountdto=new AccountDto(
		
		account.getId(),
		account.getAccountHolderName(),
		account.getBalance(),
		account.getBank_name()
		);
		return accountdto;
		
	}
}
