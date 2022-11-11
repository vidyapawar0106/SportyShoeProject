package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer>{
	
@Query("select user from User user where user.username=?1")	
	public Optional<User> findByUsername(String username);
@Query("select user from User user where user.password=?1")		
	public Optional<User> findByPassword(String password);
	


}
