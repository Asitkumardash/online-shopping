package com.niit.Shoppingcart.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dto.Category;
import com.niit.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value = { "/admin" })
public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	
	
	
	
	@RequestMapping(value="/addproduct")
	public ModelAndView addProduct(@ModelAttribute("command")Product product,BindingResult result){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Add Product");
		mv.addObject("userClickedAddProduct", true);
		mv.addObject("product",product);
		return mv;
				
	}
	
	@RequestMapping(value="/viewproduct")
	public ModelAndView viewProduct(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "View Product");
		mv.addObject("userClickedViewProduct", true);
		
		
		Product product = null;
		mv.addObject("product",productDAO.list());
		
		mv.addObject("userClickedViewProduct", true);
		return mv;
	}
	
	@Autowired
	ServletContext req;
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value="/saveproduct")
	public ModelAndView saveProduct(@ModelAttribute("command") Product product, BindingResult result){
		ModelAndView mv=new ModelAndView("page");
		
		mv.addObject("title", "save Product");
		
		
		String p=req.getRealPath("/");
		String path=product.getFilePath(p, req.getContextPath());
		
		if(product.getPid()==0) {
			
		boolean b=productDAO.add(product);
		//System.out.println("3");
		if(b) mv.addObject("Usermsg","product added");
		else mv.addObject("Usermsg","product not added");
		}
		else
		{
			boolean b=productDAO.update(product);
			//System.out.println("3");
			if(b) mv.addObject("Usermsg","product updated");
			else mv.addObject("Usermsg","product not updated");
			
		}
		mv.addObject("userClickedViewProduct", true);
		return mv;
	
}
	@RequestMapping("/productDelete/{id}")
	public ModelAndView deleteProduct(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("page");
		Product product = null;
		product=productDAO.get(id);
		
		boolean b = productDAO.delete(product);
		if(b) mv.addObject("Usermsg","product deleted");
	      else
		mv.addObject("Usermsg","product not deleted");
		mv.addObject("userClickedViewProduct", true);
		return mv;
	}
	@RequestMapping(value="/productEdit/{id}")
	public ModelAndView editProduct(@PathVariable("id") int id) {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "save product");
		
		
		
		mv.addObject("product",productDAO.get(id));
		
		
		
		mv.addObject("userClickedAddProduct", true);
		return mv;
	
	}
}

