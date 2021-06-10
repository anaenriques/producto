/*
 * Product's Repository
 * @author: sinsajoTeam
 * @version: v1.0
 */
package com.producto.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.producto.model.Product;

/**
 * The Interface ProductRepository.
 */
@Repository
@Qualifier("ProductRepository")
public interface ProductRepository extends JpaRepository<Product,Integer>{
	
}
