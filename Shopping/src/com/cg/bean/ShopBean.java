package com.cg.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class ShopBean {
	
	
	@Id
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "product_name", length = 30)
	private String productName;
	
	@Column(name = "product_price")
	private double productPrice;
	
	@Column(name = "product_quantity")
	private int productQuantity;
	
	@Column(name = "description",length=40)
	private String description;

	@Override
	public String toString() {
		return "ShopBean [productId=" + productId + ", productName="
				+ productName + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", description="
				+ description + "]";
	}

	public ShopBean(int productId, String productName, double productPrice,
			int productQuantity, String description) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.description = description;
	}

	public ShopBean() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}


/*create table Product(product_id number(5) primary key,
product_name varchar2(30),product_price Number(10),
product_quantity number(5),description varchar2(40));*/