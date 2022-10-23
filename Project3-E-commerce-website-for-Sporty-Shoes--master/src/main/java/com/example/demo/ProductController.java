package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProductController {

	@Autowired
	ProductDAO dao;
	Logger log = Logger.getAnonymousLogger();

	

	
	@RequestMapping("/product")
	public ModelAndView reDirect(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		log.info("in request mapping /");
		mv.setViewName("product.jsp");
		log.info("loaded admin page");
		return mv;
	}
	
	@RequestMapping("/addProduct")
	public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addProduct.jsp");
		return mv;
	}
	
	@RequestMapping("/insert")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		Product p = new Product();
		String insertmsg = "Record Inserted Successfully!!";
		p.setSname(request.getParameter("sname"));
		p.setScost(request.getParameter("scost"));
		Product pp = dao.insert(p);
		if (pp != null) {
			mv.addObject("msg", insertmsg);
			List<Product> list = dao.getAll();
			
			mv.addObject("list", list);
			mv.setViewName("admin.jsp");
		} else {
			mv.setViewName("fail.jsp");
		}

		return mv;
	}
	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		Product p = new Product();
		String updatemsg = "Record Updated Successfully!!";
		p.setSid(Integer.parseInt(request.getParameter("sid")));
		p.setSname(request.getParameter("sname"));
		p.setScost(request.getParameter("scost"));
		Product pp = dao.update(p);
		if (pp != null) {
			mv.addObject("msg", updatemsg);
			List<Product> list = dao.getAll();
			
			mv.addObject("list", list);
			mv.setViewName("admin.jsp");
		} else {
			mv.setViewName("fail.jsp");
		}

		return mv;
	}

	@RequestMapping("/edit")
	public ModelAndView editRedirect(HttpServletRequest request, HttpServletResponse response) {
System.out.println("Inside /edit mapping");
		ModelAndView mv = new ModelAndView();
		Product p = new Product();
		
		request.setAttribute("sid",Integer.parseInt(request.getParameter("sid")));
		request.setAttribute("sname",request.getParameter("sname"));
		request.setAttribute("scost",request.getParameter("scost"));
		
		
		mv.setViewName("editProduct.jsp");
		
		return mv;
	}
	
	@RequestMapping("/delete")  
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response)  
    { 
		ModelAndView mv = new ModelAndView();
		Product p = new Product();
		String deletemsg = "Record Deleted Successfully!!";
		int id= Integer.parseInt(request.getParameter("sid"));
		request.setAttribute("sname",request.getParameter("sname"));
		request.setAttribute("scost",request.getParameter("scost"));
		
		dao.delete(id);
		
			mv.addObject("msg", deletemsg);
			List<Product> list = dao.getAll();
			mv.addObject("list", list);
			mv.setViewName("admin.jsp");
			
        return mv;  
    }  

	@RequestMapping("/getall")
	public ModelAndView getall(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<Product> list = dao.getAll();
		mv.setViewName("displayproduct");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/addToCart")
	public ModelAndView addToCart(HttpServletRequest request, HttpServletResponse response) {
System.out.println("Inside /addToCart mapping");
		ModelAndView mv = new ModelAndView();
		Product p = new Product();
		//int count = 0;
		
		request.setAttribute("sid",Integer.parseInt(request.getParameter("sid")));
		request.setAttribute("sname",request.getParameter("sname"));
		request.setAttribute("scost",request.getParameter("scost"));
		request.setAttribute("userid",Integer.parseInt(request.getParameter("uid")));
		request.setAttribute("username",request.getParameter("username"));
		request.setAttribute("password",request.getParameter("password"));
		
		//request.setAttribute("count",++count);
		List<Product> list = dao.getAll();
		
		mv.addObject("list", list);
		mv.setViewName("buyProduct.jsp");
		
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/orderProduct")
	public ModelAndView placeOrder(HttpServletRequest request, HttpServletResponse response) {
		log.info("in request mapping /orderProduct");
		ModelAndView mv = new ModelAndView();
		
		
		String msg ="Order Placed Successfully!!";
		
		OrderDetails order = new OrderDetails();
		order.setUserId(Integer.parseInt(request.getParameter("uid")));
		order.setShoeId(Integer.parseInt(request.getParameter("sid")));
		
		
		OrderDetails oo = dao.placeOrder(order);
		if(oo != null) {
			mv.addObject("msg", msg);
			mv.addObject("userid", order.getUserId());
			mv.setViewName("orderSuccessPage.jsp");
		}
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping("/orderReport")
	public ModelAndView viewOrderReport(HttpServletRequest request, HttpServletResponse response) {
		log.info("in request mapping /orderProduct");
		ModelAndView mv = new ModelAndView();
		
		int userid = Integer.parseInt(request.getParameter("userid"));
		String msg ="No Orders Placed yet for User : "+userid;
		
		
		List<UserOrderSummary> orderList = dao.viewOrderReport(userid);
		mv.addObject("orderList", orderList);
		
		if(orderList != null) {
			
			mv.setViewName("OrderReport.jsp");
		}
		
		return mv;
	}
}
