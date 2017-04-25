package com.niit.Shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.dto.Supplier;

@Controller
@RequestMapping(value = { "/admin" })
public class SupplierController {

	@Autowired
	private SupplierDAO supplierDAO;
	
	
	
	
	@RequestMapping(value="/addsupplier")
	public ModelAndView addSupplier(@ModelAttribute("command")Supplier supplier,BindingResult result){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Add Supplier");
		mv.addObject("userClickedAddSupplier", true);
		mv.addObject("supplier",supplier);
		return mv;
				
	}
	
	@RequestMapping(value="/viewsupplier")
	public ModelAndView viewSupplier(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "View Supplier");
		
		Supplier supplier = null;
		mv.addObject("suppliers",supplierDAO.list());
		
		mv.addObject("userClickedViewSupplier", true);
		return mv;
				
	}
	
	@RequestMapping("/supplierDelete/{id}")
	public ModelAndView deleteSupp(@PathVariable("id") int id)
	{
		ModelAndView mv = new ModelAndView("page");
		Supplier supplier = null;
		supplier=supplierDAO.get(id);
		
		boolean b = supplierDAO.delete(supplier);
		if(b) mv.addObject("Usermsg","supplier deleted");
	      else
		mv.addObject("Usermsg","supplier not deleted");
		mv.addObject("userClickedViewSupplier", true);
		return mv;
	}
	@RequestMapping(value="/supplierEdit/{id}")
	public ModelAndView editSupplier(@PathVariable("id") int id) {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "save Supplier");
		
		
		
		mv.addObject("supplier",supplierDAO.get(id));
		
		
		
		mv.addObject("userClickedAddSupplier", true);
		return mv;
	}
	@RequestMapping(value="/savesupplier")
	public ModelAndView saveSupplier(@ModelAttribute("supplier") Supplier supplier, BindingResult result){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "save Supplier");
		
		if(supplier.getSupid()==0)
		{
		boolean b=supplierDAO.add(supplier);
		if(b) mv.addObject("Usermsg","supplier added");
		else mv.addObject("Usermsg","supplier not added");
		}
		else
		{
			boolean b=supplierDAO.update(supplier);
			if(b) mv.addObject("Usermsg","supplier updated");
			else mv.addObject("Usermsg","supplier not updated");
				
			
		}
		mv.addObject("userClickedViewSupplier", true);
		return mv;
	
}
}