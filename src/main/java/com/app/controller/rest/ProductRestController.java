package com.app.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Coupon;
import com.app.model.Product;
import com.app.service.IProductService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("product")
public class ProductRestController {
	@Autowired
	private IProductService service;

	@GetMapping("test")
	public String showData() {

		return "Test";
	}

	@PostMapping("saveProduct")
	@HystrixCommand(fallbackMethod = "saveFallBackMethod")
	public String saveProduct(@RequestBody Product p) {

		Coupon cup = null;

		try {
			cup = service.validateCoupon(p.getCop().getCode());
		} catch (Exception e) {

			return "Entered Coupon is not valid";
		}
		System.out.println("coupon object" + cup);
		String msg = null;
		if (cup == null) {

			msg = "Entered Coupon is not valid";
		} else {
			Coupon coup = service.getCouponByCode(p.getCop().getCode());
			System.out.println("inside else" + coup);
			Double damt = coup.getDisAmt();
			System.out.println("prod cost entered" + p.getProdCost());
			System.out.println(damt);
			p.setProdCost(p.getProdCost() - damt);
			// p.setCouponCode(p.getCouponCode());
			String productCode = service.saveProduct(p);
			msg = "Product created with : " + productCode;
		}
		return msg;
	}

	public String saveFallBackMethod(@RequestBody Product p) {

		return "some exception raised please try after some time";
	}

	@GetMapping("/allProducts")
	public List<Product> getAllProducts() {

		List<Product> list = service.getAllProducts();
		return list;
	}

	@GetMapping("/allCoupons")
	public List<Coupon> getAllCoupons() {

		List<Coupon> list = service.getAllCoupons();
		return list;
	}

}
