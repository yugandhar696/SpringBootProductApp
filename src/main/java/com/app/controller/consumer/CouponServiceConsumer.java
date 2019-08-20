package com.app.controller.consumer;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.model.Coupon;

@FeignClient("COUPON-APP")
public interface CouponServiceConsumer {
	
	@PostMapping("coupon/addCoupon")
	public String createCoupon(@RequestBody Coupon cup);
	@GetMapping("coupon/getCoupon/{cid}/{code}")
	public Coupon findCoupon(@PathVariable("cid") int cid, @PathVariable("code")String code);
	@GetMapping("coupon/all")
	public List<Coupon> getAllCoupons() ;
	@GetMapping("coupon/getCoupon/{code}")
	public Coupon getCouponByCode(@PathVariable("code") String code) ;
}
