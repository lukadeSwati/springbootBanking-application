package com.Banking_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Banking_application.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>
{
	

}
