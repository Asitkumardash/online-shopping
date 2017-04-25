package com.niit.Shoppingcart.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.CartItemDAO;
import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.Cart;
import com.niit.shoppingbackend.dto.CartItem;
import com.niit.shoppingbackend.dto.UserTable;

@Controller
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CartItemDAO cartItemDAO;
	
	@Autowired
	private HttpSession session;

	
	@RequestMapping(value={"/mycart"})
	public ModelAndView myCart(Principal principal){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "my Cart");
		
		UserTable user = userDAO.getUserByEmail(principal.getName());
		// getting cart
		Cart cart =user.getCart();
		
		//getting cartitem
		List<CartItem> cilist = cartItemDAO.getByUserid(user.getUid());
		
		mv.addObject("cilist",cilist);
		mv.addObject("user",user);
		mv.addObject("cartamt",user.getCart().getItems());
		mv.addObject("cartdata",user.getCart());
		mv.addObject("userClickedMyCart", true);
		//mv.addObject("products",productDAO.list());
		return mv;
				
	}
	
	
}