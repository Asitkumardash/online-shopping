package com.niit.Shoppingcart.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.AddressDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.Address;
import com.niit.shoppingbackend.dto.UserTable;

@Controller
@RequestMapping(value = { "/user" })
public class AddressController {
	
	@Autowired
	AddressDAO addressDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/manageAddress")
	public ModelAndView addAddress(Principal principal, @ModelAttribute("address") Address address,BindingResult result){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Manage addresses");
		UserTable user=userDAO.getUserByEmail(principal.getName());
		
		mv.addObject("addresses", addressDAO.getByUserID(user.getUid()));
		
		mv.addObject("userClickedShippingAddress", true);
		mv.addObject("address",address);
		return mv;
				
	}
	
	@RequestMapping("/deleteAddresses/{id}")
	public ModelAndView deleteAddresses(@PathVariable("id") int id, Principal principal, @ModelAttribute("address") Address address1, BindingResult result) {
		// actually you have to take the data from db
		// temporarily
		
		//log.debug("Starting of delete address method");
		
		
		ModelAndView mv = new ModelAndView("page");
		
		UserTable user=userDAO.getUserByEmail(principal.getName());
		
		Address address=null;
		address=addressDAO.get(id);

		
		boolean b=addressDAO.delete(address);
		
		if(b) System.out.println("address deleted");
		else System.out.println("Address not deleted");
		
		
		
		UserTable user1=userDAO.getUserByEmail(principal.getName());

		//passing the list of addresses
		mv.addObject("addresses",addressDAO.getByUserID(user.getUid()));
		
		mv.addObject("userClickedShippingAddress", true);
		//log.debug("End of delete address method");
		
		return mv;
	}
	

	@RequestMapping(value="/addNewAddress")
	public ModelAndView addNewAddress(Principal principal, @ModelAttribute("address") Address address,BindingResult result){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Manage addresses");
		
		UserTable user=userDAO.getUserByEmail(principal.getName());
		
		//mv.addObject("addresses", addressDAO.getByUserID(user.getUid()));
		
		
		address.setAid(user.getUid());
		
		if(address.getAddid() == 0)
		{
			boolean b = addressDAO.add(address);
			if(b) System.out.println("New address added");
			else System.out.println("New address not added");
				
		}
		else {
			
			boolean c = addressDAO.update(address);
			if(c) System.out.println("Address updated");
			else System.out.println("Address not updated");
		}
		
		UserTable user1=userDAO.getUserByEmail(principal.getName());
		//passing the list of addresses
		mv.addObject("addresses",addressDAO.getByUserID(user1.getUid()));
				
		
		mv.addObject("userClickedShippingAddress", true); 
		
		Address address1 = new Address();
		mv.addObject("address",address1);
		
		return mv;
				
	}

	@RequestMapping("/updateAddresses/{id}")
	public ModelAndView updateAddresses(@PathVariable("id") int id, Principal principal, @ModelAttribute("address") Address address1, BindingResult result) {
		// actually you have to take the data from db
		// temporarily
		
		ModelAndView mv = new ModelAndView("page");
		
		UserTable user=userDAO.getUserByEmail(principal.getName());
		
		Address address=null;
		address=addressDAO.get(id);

		mv.addObject("address",address);
		
		
		//passing the list of addresses
		mv.addObject("addresses",addressDAO.getByUserID(user.getUid()));
		
		mv.addObject("userClickedShippingAddress", true);
		
		return mv;
	}

	
}
