package com.app.service;


import java.util.List;

import com.app.model.Coupon;
import com.app.model.Product;

public interface IProductService {
	
	public String saveProduct(Product p);
	public List<Product> getAllProducts();
	public Coupon validateCoupon(String code);
	public List<Coupon> getAllCoupons(); 
	public Coupon getCouponByCode(String code) ;
}
