
package com.niit.shoppingbackend.dto;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Component
public class Product implements Serializable {
	
	/*
	 * private variables
	 * */
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2273001400951998901L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	@Column
	private String pname;
	@Column
	private String pdesc;
	@Column
	private int cid;
	@Column
	private int price;
	
	
	@Column
	private String pimage;
	
	@Transient
	transient private MultipartFile image;
	
	
	@Column
	private String pcolor;

	public String getPcolor() {
		return pcolor;
	}
	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}

	@Column(name="is_active") 
	private boolean active = true;
	
	
	
	
	/*
	 * Setter getter methods
	 * */
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	/*
	 * toString() method
	 * 
	 * */
	
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pdesc=" + pdesc + ", cid=" + cid + ", price=" + price
				+ ", pimage=" + pimage + ", pcolor=" + pcolor + ", active=" + active + "]";
	}
	


public String getFilePath(String path1,String contextPath) {

	String fileName=null;
	
	if (!image.isEmpty()) {
		try {
			

			fileName=image.getOriginalFilename();
			byte[] bytes = image.getBytes();
			String npath=path1+"\\assets\\images\\"+fileName;

			
			BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(npath)));  
			stream.write(bytes);  
			stream.close();
			String dbfileName = contextPath+"/resources/images/"+fileName;
			//String dbfileName = fileName;
			this.setPimage(dbfileName);
			
			return dbfileName;
		} catch (Exception e) {
			return "You failed to upload " + " => " + e.getMessage();
		}
	} else {
		return "You failed to upload because the file was empty.";
	}
}

}