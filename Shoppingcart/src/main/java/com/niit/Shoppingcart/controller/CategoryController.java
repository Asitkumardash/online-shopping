package com.niit.Shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dto.Category;
import com.niit.shoppingbackend.dto.Supplier;

@Controller
@RequestMapping(value = { "/admin" })
public class CategoryController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value="/addcategory")
	public ModelAndView addCategory(@ModelAttribute("command")Category category,BindingResult result){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Add Category");
		mv.addObject("userClickedAddCategory", true);
		mv.addObject("category",category);
		return mv;
				
	}
	
	@RequestMapping(value="/viewcategory")
	public ModelAndView viewCategory(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "View Category");
		mv.addObject("userClickedViewCategory", true);
		
				
	
	
	Category category = null;
	mv.addObject("categories",categoryDAO.list());
	
	mv.addObject("userClickedViewCategory", true);
	return mv;
			
}

@RequestMapping("/categoryDelete/{id}")
public ModelAndView deleteCategory(@PathVariable("id") int id)
{
	ModelAndView mv = new ModelAndView("page");
	Category category = null;
	category=categoryDAO.get(id);
	
	boolean b = categoryDAO.delete(category);
	if(b) mv.addObject("Usermsg","category deleted");
      else
	mv.addObject("Usermsg","category not deleted");
	mv.addObject("userClickedViewCategory", true);
	return mv;
}

	@RequestMapping
	(value="/savecategory")
	public ModelAndView saveCategory(@ModelAttribute("command") Category category, BindingResult result){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "save Category");
		if(category.getId()==0)
		{
		boolean b=categoryDAO.add(category);
		if(b) mv.addObject("Usermsg","category added");
		else mv.addObject("Usermsg","category not added");
		}
		else
		{
			boolean b=categoryDAO.update(category);
			if(b) mv.addObject("Usermsg","category updated");
			else mv.addObject("Usermsg","category not updated");
				
			
		}
		mv.addObject("userClickedViewCategory", true);
		return mv;
	
}

	@RequestMapping(value="/categoryEdit/{id}")
	public ModelAndView editCategory(@PathVariable("id") int id) {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "save Category");
		
		
		
		mv.addObject("category",categoryDAO.get(id));
		
		
		
		mv.addObject("userClickedAddCategory", true);
		return mv;
	
	}
	
}

