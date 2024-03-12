package com.Banking_application.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Banking_application.dto.AccountDto;
import com.Banking_application.entity.Account;
import com.Banking_application.mapper.AccountMapper;
import com.Banking_application.repository.AccountRepository;
import com.Banking_application.service.AccountService;

@Service
public class AccountserviceImpl implements AccountService {
	
	
	private AccountRepository accountRepository;
	

	public AccountserviceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}


	


	@Override
	public AccountDto createAccount(AccountDto accountdto) {
		// TODO Auto-generated method stub
		
		Account account=AccountMapper.mapToAccount(accountdto);
		Account savedAccount=accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
		
	}





	@Override
	public AccountDto getAccountById(Long id) {
		Account account=accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist.."));
		return AccountMapper.mapToAccountDto(account);
	}





	@Override
	public AccountDto deposit(long id, double amount) {
		
		Account account=accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist.."));
		double totalbalance=account.getBalance()+amount;
		account.setBalance(totalbalance);
		Account savedaccount=accountRepository.save(account);

		
		return AccountMapper.mapToAccountDto(savedaccount);
	}





	@Override
	public AccountDto withdraw(long id, double amount) {
		
		Account account=accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist.."));
		if(account.getBalance()<amount)
		{
			throw new RuntimeException("Insufficieant Balance");
		}
		double totalbalance=account.getBalance()-amount;
		account.setBalance(totalbalance);
		Account savedaccount=accountRepository.save(account);

		
		return AccountMapper.mapToAccountDto(savedaccount);
	}





	@Override
	public List<AccountDto> getAllAccount() {
		
		return accountRepository.findAll().stream().map((account)->AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
		
	}





	@Override
	public void deleteAccount(Long id) {
		Account account=accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist.."));
		accountRepository.delete(account);
	}
	
}
