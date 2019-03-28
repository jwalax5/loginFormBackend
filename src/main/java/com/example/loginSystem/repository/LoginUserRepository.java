package com.example.loginSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.loginSystem.model.LoginUser;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {
	
	@Query("SELECT user FROM LoginUser user WHERE user.email = ?1 AND user.password = ?2")
	LoginUser findByEmailAndPassword(String email, String password);
	
	@Query("SELECT user FROM LoginUser user WHERE user.email = ?1")
	LoginUser checkIfEmailAlreadyExist(String email);
}
