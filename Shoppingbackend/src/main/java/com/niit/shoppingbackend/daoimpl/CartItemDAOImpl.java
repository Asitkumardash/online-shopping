package com.niit.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.dao.CartItemDAO;
import com.niit.shoppingbackend.dto.CartItem;


@Repository("cartitemDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public CartItem get(int id) {

		return sessionFactory.getCurrentSession().get(CartItem.class, Integer.valueOf(id));
		 
	}

	@Override
	public List<CartItem> list() {
		String selectActiveCartitem = "FROM CartItem WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCartitem);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public boolean add(CartItem cartitem) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().save(cartitem);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(CartItem cartitem) {
		try {
			
			sessionFactory.getCurrentSession().update(cartitem);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(CartItem cartitem) {
		//cartitem.setActive(false);
		 
		try {
	
			sessionFactory.getCurrentSession().delete(cartitem);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	
		
	
	
	
	@Override
	public List<CartItem> getByUserid(int userid) {
		String selectActiveCartitem = "FROM CartItem WHERE active = :active and userid = :userid";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCartitem);
		
		query.setParameter("active", true);
		query.setParameter("userid", userid);
		
		return query.getResultList();
	}

	@Override
	public boolean productExists(int userid, int pid) {
		String selectActiveCartitem = "FROM CartItem WHERE active = :active and pid = :pid and userid = :userid";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCartitem);
		
		query.setParameter("active", true);
		query.setParameter("pid", pid);
		query.setParameter("userid", userid);
		System.out.println(query);
		try{
		
		if(query.getSingleResult()==null) return false;
		else return true;
		}
		catch(Exception e) {
			System.out.println("exception occurred");
			return false;
		}
		
	}

	@Override
	public CartItem getByPid(int userid, int pid) {
		String selectActiveCartitem = "FROM CartItem WHERE active = :active and pid = :pid and userid = :userid";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCartitem);
		
		query.setParameter("active", true);
		query.setParameter("pid", pid);
		query.setParameter("userid", userid);

		return (CartItem) query.getSingleResult();
	}

	@Override
	public boolean placeOrder(CartItem cartitem) {
		cartitem.setActive(false);
		 
		try {
	
			sessionFactory.getCurrentSession().update(cartitem);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<CartItem> getOrderedItems(int userid, int oid) {
		String selectActiveCartitem = "FROM CartItem WHERE active = :active and userid = :userid and oid = :oid";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCartitem);
		
		query.setParameter("active", false);
		query.setParameter("userid", userid);
		query.setParameter("oid", oid);
		
		return query.getResultList();
	}
	

}