package com.niit.Shoppingcart.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.CartDAO;
import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.Cart;
import com.niit.shoppingbackend.dto.Category;
import com.niit.shoppingbackend.dto.Product;
import com.niit.shoppingbackend.dto.UserTable;

@Controller
public class PageController {

	            @Autowired
	            private CategoryDAO categoryDAO;
		
				@Autowired
				private HttpSession session;
		
				@Autowired
				private ProductDAO productDAO;
				
				@Autowired
				private UserDAO userDAO;
		
				@Autowired
				private CartDAO cartDAO;
		
				
				
				
				@RequestMapping(value={"/","/home","/index"})
				public ModelAndView index(){
					ModelAndView mv=new ModelAndView("page");
					mv.addObject("title", "Home");
					//passing the list of categories
					mv.addObject("categories",categoryDAO.list());
					
					mv.addObject("userClickedHome", true);
					mv.addObject("products",productDAO.list());
					return mv;
							
				}
				
				@RequestMapping(value={"/about"})
				public ModelAndView about(){
					ModelAndView mv=new ModelAndView("page");
					mv.addObject("title", "About Us");
					mv.addObject("userClickedAbout", true);
					return mv;
				}
				
				@RequestMapping(value={"/contact"})
				public ModelAndView contact(){
					ModelAndView mv=new ModelAndView("page");
					mv.addObject("title", "Contact Us");
					mv.addObject("userClickedContact", true);
					return mv;
				}
				
				@RequestMapping(value={"/loginerror"})
				public ModelAndView loginerror(){
					ModelAndView mv=new ModelAndView("page");
					mv.addObject("title", "Login Error");
					mv.addObject("userClickedLoginError", true);
					return mv;
				}
				
				
				@RequestMapping(value = { "/login" })
				public ModelAndView showLoginPage() {
					//log.debug("Starting of login method");
					System.out.println("clicked on login page");
					ModelAndView mv = new ModelAndView("page");
					mv.addObject("title", "login");

					// passing the list of categories
					//mv.addObject("categories", categoryDAO.list());

					mv.addObject("userClickedLogin", true);
					//log.debug("End of login method");
					
					return mv;
				}
				
				@RequestMapping(value = "/logout", method = RequestMethod.GET)
				public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
					Authentication auth = SecurityContextHolder.getContext().getAuthentication();
					if (auth != null) {
						new SecurityContextLogoutHandler().logout(request, response, auth);
					}
					
					ModelAndView mv=new ModelAndView("page");
					//session.invalidate(); // session.removeAttribute("loginMessage");
					mv.addObject("title", "Home");
					
					//passing the list of categories
					//mv.addObject("categories",categoryDAO.list());
					
					//passing the list of products
							mv.addObject("products", productDAO.list());
					
					
					
					mv.addObject("isUserClickedLogout", true);
					return mv;
				}
				
				@PostMapping("/validate")
				public ModelAndView validateCredentials(@RequestParam(value="userID",required=true) String id, @RequestParam(value="password",required=true) String pwd)
				{
					//actually you have to take the data from db
					//temporarily
					ModelAndView mv=new ModelAndView("/page");
					
					if(id.equals("niit") && pwd.equals("niit@123"))
					{
						mv.addObject("successMessage","Valid credentials");
						session.setAttribute("loginMessage","Welcome :"+id);
						
					}
					else
					{
						mv.addObject("errorMessage","Invalid credentials please try again");
					}
					
					return mv;
				}

				

				@RequestMapping("/registration")
				public ModelAndView showRegistrationPage(@ModelAttribute("user")  UserTable user, BindingResult result)
				{
					System.out.println("Clicked on registration link");
					ModelAndView mv=new ModelAndView("/page");
					mv.addObject("userClickedRegister", "true");
					return mv;
				}
				

				@RequestMapping("/register")
				public ModelAndView AddUserPage(@ModelAttribute("user") @Valid UserTable user, BindingResult result)
				{
					System.out.println("AddUserPage method");
					ModelAndView mv=new ModelAndView("/page");
					
					if(result.hasErrors()){
						mv.addObject("userClickedRegister", true);
						return mv;
					}
					
					// giving cart
					Cart cart = new Cart();
					boolean x = cartDAO.add(cart);
					if(x) System.out.println("Cart added");
					else System.out.println("Cart not added");
					user.setCart(cart);
					
					boolean b=userDAO.add(user);
					if(b) mv.addObject("Usermsg","User registred successfully");
					else mv.addObject("Usermsg","User NOT registred successfully");
					
					
					mv.addObject("userClickedRegister", "true");
					return mv;
				}
				
				
				@RequestMapping("/productdetails/{id}")
				public ModelAndView productdetails(@PathVariable("id") int id)
				{
					System.out.println("Clicked on product details link");
					ModelAndView mv = new ModelAndView("/page");
					
					Product product=productDAO.get(id);
					mv.addObject("product",product);
					
					mv.addObject("userClickedProductdetails","true");
					
					return mv;
				}
				@RequestMapping(value={"/user/myAccount"})
				public ModelAndView Account(Principal principal){
					ModelAndView mv=new ModelAndView("page");
					UserTable user = userDAO.getUserByEmail(principal.getName());
					mv.addObject("user",user);
					mv.addObject("title", "Account");
					mv.addObject("userClickedAccount", true);
					return mv;
				}
				@RequestMapping(value = {"/show/all/products"})
				public ModelAndView showAllProducts() {
					ModelAndView mv=new ModelAndView("page");
					mv.addObject("title", "All Products");
					
					//passing the list of category
					mv.addObject("categories",categoryDAO.list());
					
					// product list 
					mv.addObject("products",productDAO.list());
					
					mv.addObject("userClickAllProducts",true);
					return mv;
				}
				
				@RequestMapping(value = {"/show/category/{id}/products"})
				public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
					ModelAndView mv=new ModelAndView("page");
					
					//categoryDAO to fetch a single category
					Category category= null;
					category= categoryDAO.get(id);
					
					mv.addObject("title", category.getName());
					
					//passing the list of category
					mv.addObject("categories",categoryDAO.list());
					
					//passing the single category object
					mv.addObject("category",category);
					
					// list of category-wise products
					mv.addObject("catProducts",productDAO.listActiveProductsByCategory(id));
					
					mv.addObject("userClickCategoryProducts",true);
					return mv;
				}
				
				
				
				
				 
				@RequestMapping(value="/show/{id}/product")
				public ModelAndView showSingleProduct(@PathVariable int id) throws Exception {
					ModelAndView mv=new ModelAndView("page");
					
					Product product = productDAO.get(id);
					if(product == null) throw new Exception();
					
					//update the views
					product.setPrice(product.getPrice()+1);
					productDAO.update(product);
					//-------------------------
					mv.addObject("title",product.getPimage());
					mv.addObject("title",product.getPname());
					mv.addObject("product",product);
					mv.addObject("userClickShowProduct",true);
					
					return mv;
				}
				
				
				
				 }


			
			
		



