package com.wes.pma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wes.pma.entities.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}
