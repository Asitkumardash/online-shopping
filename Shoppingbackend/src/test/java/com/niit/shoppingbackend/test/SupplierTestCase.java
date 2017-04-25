package com.niit.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.dto.Supplier;

public class SupplierTestCase {

private static AnnotationConfigApplicationContext context;
	
	private static SupplierDAO supplierDAO;
	
	private Supplier supplier;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingbackend");
		context.refresh();
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

}
	@Test
	public void testCRUDCategory() {
		//add operation
		supplier =new Supplier();
		
		supplier.setSupname("sup 1");
		supplier.setSupdescription("This is some desc for Macintosh");
		
		
		assertEquals("Successfully added a category inside the table",true,supplierDAO.add(supplier));
		
		supplier =new Supplier();
		
		supplier.setSupname("Sup 2");
		supplier.setSupdescription("This is some desc for alienware");
	
		
		assertEquals("Successfully added a category inside the table",true,supplierDAO.add(supplier));
		
		//fetchaing and updating
		supplier = supplierDAO.get(2);
		
		supplier.setSupname("sup 3-X");
	
		assertEquals("Successfully updated a category in the table",true,supplierDAO.update(supplier));
		supplier = supplierDAO.get(2);
		assertEquals("Successfully deleted a category in the table",true,supplierDAO.delete(supplier));
		
		//fetching the list
		assertEquals("Successfully fetched the list of a categories from the table",11,supplierDAO.list().size());
		
	}
}

