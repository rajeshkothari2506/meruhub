package com.meru.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meru.order.model.OrderStatus;
import com.meru.order.service.OrderService;

@RestController
public class OrderServiceController {
	
	@Autowired
	OrderService  orderService;
	
	
	@PostMapping("/updateorderstatus")
	public void creatOrUpdateOrderDetails(@RequestBody OrderStatus orderStatus) {
		orderService.creatOrUpdateOrderDetails(orderStatus);
	}
	
	

}
