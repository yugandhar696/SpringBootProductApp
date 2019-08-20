package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coupon {
	@Id
	@GeneratedValue
	private Integer cid;
	private String code;
	private Double disAmt;
	private String expDate;
	
	public Coupon() {
		super();
	}
	public Coupon(Integer id, Integer cid, String code, Double disAmt, String expDate) {
		super();
		this.cid = cid;
		this.code = code;
		this.disAmt = disAmt;
		this.expDate = expDate;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getDisAmt() {
		return disAmt;
	}
	public void setDisAmt(Double disAmt) {
		this.disAmt = disAmt;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	@Override
	public String toString() {
		return "Coupon [cid=" + cid + ", code=" + code + ", disAmt=" + disAmt + ", expDate=" + expDate
				+ "]";
	}
	
	
}
