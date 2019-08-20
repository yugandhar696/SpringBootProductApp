package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Integer id;
	private Integer prodId;
	private String prodCode;
	private Double prodCost;
	@Transient
	private Coupon cop;

	public Product() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public Double getProdCost() {
		return prodCost;
	}

	public void setProdCost(Double prodCost) {
		this.prodCost = prodCost;
	}

	public Coupon getCop() {
		return cop;
	}
	public void setCop(Coupon cop) {
		this.cop = cop;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", prodId=" + prodId + ", prodCode=" + prodCode + ", prodCost=" + prodCost
				+ ", cop=" + cop + "]";
	}

}
