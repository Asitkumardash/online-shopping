package com.niit.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
@Component
@Entity
public class CartItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5464426419678705058L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemid;
	
	@Column
	private int userid;
	
	 
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	@OneToOne
	@JoinColumn(name="pid")
	private Product product;
	
	@Column
	private long cprice;
	@Column
	private int cquantity;
	@Column
	private long ctotal;
	
	@Column
	private int oid=0;

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}

	@Column(name="is_active")
	private boolean active = true;
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	
	
	public long getCprice() {
		return cprice;
	}
	public void setCprice(long cprice) {
		this.cprice = cprice;
	}
	public int getCquantity() {
		return cquantity;
	}
	public void setCquantity(int cquantity) {
		this.cquantity = cquantity;
	}
	public long getCtotal() {
		return ctotal;
	}
	public void setCtotal(long ctotal) {
		this.ctotal = ctotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Cartitem [itemid=" + itemid + ", userid=" + userid + ", product=" + product + ", cprice=" + cprice
				+ ", cquantity=" + cquantity + ", ctotal=" + ctotal + ", oid=" + oid + ", active=" + active + "]";
	}
	
}