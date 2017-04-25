package com.niit.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dto.Product;

public class ProductTestCase {

private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingbackend");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		
	}
	
/* @Test
	public void testAddCategory()
	{
		category =new Category();
		
		category.setName("Samsung");
		category.setDescription("This is some desc for Samsung");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
		
		
	}*/
	
	/*@Test
	public void testGetCategory() {
		
		
		category = categoryDAO.get(1);
		
		assertEquals("Successfully fetched a category inside the table","Samsung",category.getName());
		
	}*/
		
	/*	@Test
		public void testUpdateCategory() {
		
		
			category = categoryDAO.get(1);
			
			category.setName("SAMSUNG");
		
			assertEquals("Successfully updated a category in the table",true,categoryDAO.update(category));
		
		}
	*/
	
	/*@Test
	public void testDeleteCategory() {
	
	
		category = categoryDAO.get(1);
		assertEquals("Successfully deleted a category in the table",true,categoryDAO.delete(category));
	
	}*/
	
	/* @Test
	public void testListCategory() {  
	
		assertEquals("Successfully fetched the list of a categories from the table",1,categoryDAO.list().size());
	
	} */
	
	@Test
	public void testCRUDCategory() {
		//add operation
		product =new Product();
		product.setPid(12);
		product.setPname("Macintosh");
		product.setPdesc("This is some desc for Macintosh");
	    product.setPimage("cat3.png");
		product.setPcolor("red");
		product.setCid(80);
		product.setPrice(12000);
		product.setActive(true);
		
		assertEquals("Successfully added a category inside the table",true,productDAO.add(product));
		
		
		//fetchaing and updating
		product = productDAO.get(49);
		
		product.setPname("OS-X");
	
		assertEquals("Successfully updated a category in the table",true,productDAO.update(product));
		
		//delete the category
		product = productDAO.get(49);
		assertEquals("Successfully deleted a category in the table",true,productDAO.delete(product));
		
		//fetching the list
		assertEquals("Successfully fetched the list of a categories from the table",11,productDAO.list().size());
		
	}
	
}




