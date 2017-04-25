package com.niit.Shoppingcart.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.CartDAO;
import com.niit.shoppingbackend.dao.CartItemDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.Cart;
import com.niit.shoppingbackend.dto.CartItem;
import com.niit.shoppingbackend.dto.Product;
import com.niit.shoppingbackend.dto.UserTable;
@Controller
@RequestMapping(value = { "/user" })
public class CartController {

	@Autowired
	private HttpSession session;

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private CartItemDAO cartItemDAO;
	
	@RequestMapping("/addToCart/{pid}")
	public ModelAndView addToCart(@PathVariable("pid") int pid, Principal principal)
	{
		ModelAndView mv = new ModelAndView("page");
		
		UserTable user = userDAO.getUserByEmail(principal.getName());
		
		Cart cart = user.getCart();
		Product product = productDAO.get(pid);
		// cart setup
		int items = cart.getItems();
		items++;
		cart.setItems(items);
		
		long cost = cart.getTotalcost();
		cost += product.getPrice();
		cart.setTotalcost(cost);
		
		boolean b= cartDAO.update(cart);
		if(b) System.out.println("cart updated");
		else System.out.println("Cart not updated");
		
		//  cartitems setup
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setUserid(user.getUid());
		cartItem.setCprice(product.getPrice());
		cartItem.setCquantity(1);
		cartItem.setCtotal(product.getPrice());
		cartItem.setOid(0);
		
		boolean c = cartItemDAO.add(cartItem);
		if(c) System.out.println("Cartitem added");
		else System.out.println("cart item not added");
		
		System.out.println("Product added to the cart");
		
		mv.addObject("products",productDAO.list());
		
		
		mv.addObject("userClickedHome", true);
		return mv;
	}
	
	@RequestMapping("/removeCartItem/{ctid}")
	public ModelAndView removeCartItem(@PathVariable("ctid") int ctid, Principal principal) {
		
		ModelAndView mv = new ModelAndView("page");
		UserTable user = userDAO.getUserByEmail(principal.getName());
		
		Cart cart = user.getCart();
		CartItem cartitem = cartItemDAO.get(ctid);
		int qu = cartitem.getCquantity();
		int cartq = cart.getItems() - qu;
		cart.setItems(cartq);
		
		long tcost = cartitem.getCtotal();
		long cartt = cart.getTotalcost() - tcost;
		cart.setTotalcost(cartt);
		
		boolean b = cartItemDAO.delete(cartitem);
		if(b) mv.addObject("cartmsg","cartitem deleted");
		else mv.addObject("cartmsg","cartitem deleted");
		
		boolean c = cartDAO.update(cart);
		if(c) System.out.println("Cart updated");
		else System.out.println("cart not updated");
		
		mv.addObject("userClickedMyCart",true);
		return mv;
	}
}
