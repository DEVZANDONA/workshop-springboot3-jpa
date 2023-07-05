package com.educandoweb.Course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.Course.entities.OrderItem;



public interface OrderItemRepository extends JpaRepository<OrderItem,Long>{

	
}
