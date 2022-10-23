package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepo extends JpaRepository<User, Integer> {

	
	@Query("select user from User user where user.uname=?1 and user.upassword=?2")
	public User validateUser(String user,String Password);
}
