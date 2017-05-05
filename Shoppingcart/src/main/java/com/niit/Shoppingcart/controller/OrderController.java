/*package com.niit.Shoppingcart.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.AddressDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.Order;
import com.niit.shoppingbackend.dto.UserTable;

@Controller
public class OrderController {

	@Autowired
	AddressDAO addressDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value={"/selectAddress"})
	public ModelAndView selectAddress(Principal principal){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Select address");
		
		UserTable user = userDAO.getUserByEmail(principal.getName());
		
		mv.addObject("addresses", addressDAO.getByUserID(user.getUid()));
		
		
		mv.addObject("userClickedSelectAddress", true);
		return mv;
	}
	
	@RequestMapping(value={"/selectedAddress/{addid}"})
	public ModelAndView selectedAddress(@PathVariable int addid, Principal principal){
		ModelAndView mv=new ModelAndView("page");
		
		Order order = new Order();
		boolean x = orderDAO.add
		
		mv.addObject("userClickedSelectAddress", true);
		return mv;
	}
	
}
*/