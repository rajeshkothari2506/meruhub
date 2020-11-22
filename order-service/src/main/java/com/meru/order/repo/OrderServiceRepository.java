package com.meru.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meru.order.model.OrderStatus;


@Repository
public interface OrderServiceRepository extends JpaRepository<OrderStatus, Integer> {

}
