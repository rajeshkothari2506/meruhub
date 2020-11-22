package com.meru.composite.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.meru.composite.models.OrderStatus;

@FeignClient(name = "order-service")
public interface OrderServiceProxy {
	@PostMapping("/updateorderstatus")
	public void creatOrUpdateOrderDetails(@RequestBody OrderStatus orderStatus);

}
