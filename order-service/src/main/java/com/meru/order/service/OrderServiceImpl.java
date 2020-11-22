package com.meru.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meru.order.model.OrderStatus;
import com.meru.order.repo.OrderServiceRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderServiceRepository orderServiceRepository;
	
	@Override
	public OrderStatus creatOrUpdateOrderDetails(OrderStatus orderStatus) {
		// TODO Auto-generated method stub
		return orderServiceRepository.save(orderStatus);
	}

}
