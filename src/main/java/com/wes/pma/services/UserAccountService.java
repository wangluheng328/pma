package com.wes.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wes.pma.dao.UserAccountRepository;
import com.wes.pma.entities.UserAccount;

@Service
public class UserAccountService {

	@Autowired
	UserAccountRepository userAccountRepo;
	
	public UserAccount save(UserAccount userAccount) {
		return userAccountRepo.save(userAccount);
	}
	
}
