package com.niit.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.CartDAO;
import com.niit.shoppingbackend.dao.CartItemDAO;
import com.niit.shoppingbackend.dto.Cart;
import com.niit.shoppingbackend.dto.CartItem;

public class CartItemTestCase {

private static AnnotationConfigApplicationContext context;
	
	private static CartItemDAO cartitemDAO;
	
	private CartItem cartitem;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingbackend");
		context.refresh();
		
		cartitemDAO = (CartItemDAO) context.getBean("cartitemDAO");
		
	}
	

	
	@Test
	public void testCRUDCategory() {
		//add operation
		cartitem =new CartItem();
		
		
		cartitem.setItemid(5);
		cartitem.setOid(40);
		cartitem.setUserid(69);
		cartitem.setCquantity(2);
		cartitem.setCprice(5000);
		cartitem.setCtotal(10000);
		
		//category.setImageURL("CAT_2mac.png");
		
		assertEquals("Successfully added a cart inside the table",true,cartitemDAO.add(cartitem));
		
		cartitem =new CartItem();
		
		
		cartitem.setItemid(5);
		cartitem.setOid(70);
		cartitem.setCquantity(3);
		cartitem.setCprice(5000);
		cartitem.setCtotal(15000);
		//category.setImageURL("CAT_2mac.png");
		
		assertEquals("Successfully added a cart inside the table",true,cartitemDAO.add(cartitem));
		//fetchaing and updating
		cartitem = cartitemDAO.get(2);
		
		cartitem.setCquantity(4);
	
		assertEquals("Successfully updated a cart in the table",true,cartitemDAO.update(cartitem));
		
		//delete the category
		cartitem = cartitemDAO.get(3);
		assertEquals("Successfully deleted a cart in the table",true,cartitemDAO.delete(cartitem));
		
		//fetching the list
		assertEquals("Successfully fetched the list of a cart from the table",1,cartitemDAO.list().size());
		
	}
	
	
}
