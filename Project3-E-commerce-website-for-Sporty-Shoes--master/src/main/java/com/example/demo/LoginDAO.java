package com.example.demo;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class LoginDAO {
	
	@Autowired
	LoginRepo repo;
	
	
	
  public User validateUser(String uname,String upassword) {
	  
	  User u = repo.validateUser(uname, upassword);
	  return u;
  }
  
  public User registerUser(User u) {
	  User uu = repo.save(u);
	  
	  return uu;
  }
}
