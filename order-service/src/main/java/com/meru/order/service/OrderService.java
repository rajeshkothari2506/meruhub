package com.meru.order.service;

import org.springframework.stereotype.Service;

import com.meru.order.model.OrderStatus;
@Service
public interface OrderService {

	public OrderStatus creatOrUpdateOrderDetails(OrderStatus orderStatus);
}
