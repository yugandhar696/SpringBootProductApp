package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.controller.consumer.CouponServiceConsumer;
import com.app.model.Coupon;
import com.app.model.Product;
import com.app.repo.ProductRepository;
import com.app.service.IProductService;
@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private CouponServiceConsumer consumer;
	@Autowired
	private ProductRepository repo;
	@Override
	@Transactional
	public String saveProduct(Product p) {

		return repo.save(p).getProdCode();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> getAllProducts() {
		
		return repo.findAll();
	}

	public Coupon validateCoupon(String code) {
		System.out.println("Inside validate method"+consumer.getCouponByCode(code));
		return consumer.getCouponByCode(code);
		
		
	}

	@Override
	public List<Coupon> getAllCoupons() {
		// TODO Auto-generated method stub
		System.out.println(consumer.getAllCoupons());
		return consumer.getAllCoupons();
	}

	@Override
	public Coupon getCouponByCode(String code) {
		// TODO Auto-generated method stub
		return consumer.getCouponByCode(code);
	}
}
