package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
	ProductDAO dao;
	
	@Autowired
	LoginDAO logindao;
	Logger log = Logger.getAnonymousLogger();

	

	@ResponseBody
	@RequestMapping("/admin")
	public ModelAndView loadfrontpageadmin(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		List<Product> list = dao.getAll();
		
		mv.addObject("list", list);
		log.info("in request mapping /");
		mv.setViewName("admin.jsp");
		log.info("loaded admin page");
		return mv;
	}

	@ResponseBody
	@RequestMapping("/user")
	public ModelAndView loadfrontpageuser(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<Product> list = dao.getAll();
		
		mv.addObject("list", list);
		log.info("in request mapping /");
		mv.setViewName("user.jsp");
		log.info("loaded user page");
		return mv;
	}
	@ResponseBody
	@RequestMapping("/userLogin")
	public ModelAndView loadUserLoginPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<Product> list = dao.getAll();
		
		mv.addObject("list", list);
		log.info("in request mapping /");
		mv.setViewName("userLogin.jsp");
		log.info("loaded user page");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("loginUser")
	public ModelAndView loginAction(HttpServletRequest request, HttpServletResponse response) 
		{
			
			ModelAndView mv = new ModelAndView();
			log.info("Inside the login action");
			User s = new User();
			String username = request.getParameter("uname");
			String password = request.getParameter("upassword");
			log.info("Received input parameters  username"+username+" and password"+password);
			
			
			User u =logindao.validateUser(username, password);
			if (u !=null) {
				log.info("Login is successfull");
				List<Product> list = dao.getAll();
				mv.addObject("list", list);
				mv.setViewName("user.jsp");
				mv.addObject("userid", u.getUid());
				mv.addObject("username", username);
				mv.addObject("password", password);
				log.info("control passed to user.jsp");
			}
			
			else
			{
				String msg = "The Username and Password has some problem ,please check or else register with the below link";
				log.info("Login is unsuccessfull");
				
				mv.addObject("msg", msg);
				mv.setViewName("userLogin.jsp");
				log.info("control passed to userLogin.jsp");
			}
	        return mv;  
	     	
		
	}
	
	@ResponseBody
	@RequestMapping("/registerUser")
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		
		String msg ="User Registered successfully.Login to proceed";
		log.info("in request mapping /registerUser");
		
		User user = new User();
		
		user.setUname(request.getParameter("uname"));
		user.setUpassword(request.getParameter("upassword"));
		user.setUemail(request.getParameter("uemail"));
	
		User u = logindao.registerUser(user);
		if(u != null) {
			mv.addObject("msg", msg);
			mv.setViewName("userLogin.jsp");
		}
		return mv;
	}
	

}
