package com.niit.Shoppingcart.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.AddressDAO;
import com.niit.shoppingbackend.dao.CartItemDAO;
import com.niit.shoppingbackend.dao.OrderDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.CartItem;
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
	CartItemDAO cartitemDAO;
	
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
	
	@RequestMapping(value={"/user/addressSelected/{addid}"})
	public ModelAndView addressSelected(@PathVariable("addid") int addid,Principal principal) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "confirm purchase");
		UserTable user = userDAO.getUserByEmail(principal.getName());
		
		Order o = new Order();
		o.setAddress(addressDAO.get(addid));
		o.setUser(user);
		long amt = user.getCart().getTotalcost();
		o.setAmount(amt);
		o.setOrdered(false);
		
		boolean b = orderDAO.add(o);
		if(b) System.out.println("Order added");
		else System.out.println("Order not added");
		
		System.out.println("order id:"+o.getOrderid());
		
		List<CartItem> cartilist = cartitemDAO.getByUserid(user.getUid());
		for(CartItem carti : cartilist) {
			carti.setOid(o.getOrderid());
			boolean x = cartitemDAO.update(carti);
			if(x) System.out.println(carti.getItemid()+"Cart item updated");
			else System.out.println("Cart item not updated");
			
		}
		
		List<CartItem> clist = cartitemDAO.getByUserid(user.getUid());
		System.out.println(clist);
		mv.addObject("clist",clist);
		
		mv.addObject("user", user);
		//mv.addObject("shipaddress",o.getAddress());
		mv.addObject("orderstuff",o);
		mv.addObject("userClickedConfirmPurchase", true);
		return mv;
	}
	
	@RequestMapping(value={"/paymentMode"})
	public ModelAndView paymentMode(Principal principal){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Payment mode");
		
		UserTable user = userDAO.getUserByEmail(principal.getName());
		
		mv.addObject("addresses", addressDAO.getByUserID(user.getUid()));
		
		
		mv.addObject("userClickedPaymentMode", true);
		return mv;
	}
	// order/paymentMode.jsp
}
