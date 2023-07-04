package com.educandoweb.Course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.Course.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

	
}
