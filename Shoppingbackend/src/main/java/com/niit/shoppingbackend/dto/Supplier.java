package com.niit.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



	@Entity
	public class Supplier {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int supid;
		public int getSupid() {
			return supid;
		}
		public void setSupid(int supid) {
			this.supid = supid;
		}
		public String getSupname() {
			return supname;
		}
		public void setSupname(String supname) {
			this.supname = supname;
		}
		public String getSupdescription() {
			return supdescription;
		}
		public void setSupdescription(String supdescription) {
			this.supdescription = supdescription;
		}


		@Column
		private String supname;
		@Column
		private String supdescription;
		
		
		@Column(name = "is_active")
		private boolean active = true;
		
		
		
	
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		
		
		/*
		 * Private fields
		 */
		
		@Override
		public String toString() {
			return "Supplier [id=" + supid + ", name=" + supname + ", description=" + supdescription 
					+ ", active=" + active + "]";
		}


		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


