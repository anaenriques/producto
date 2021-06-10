package com.producto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.producto.model.Product;
import com.producto.repository.ProductRepository;
import com.producto.service.ProductServiceI;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductServiceImpl.
 */
@Service
@Qualifier("ProductServiceImpl")
public class ProductServiceImpl implements ProductServiceI{
	
	/** The product repository. */
	@Autowired
	@Qualifier("ProductRepository")
	private ProductRepository productRepository;
	
	/**
	 * List all products.
	 *
	 * @return the list
	 */
	@Override
	public List<Product> listAllProducts() {
		return productRepository.findAll();
	}

	/**
	 * Insert product.
	 *
	 * @param product the product
	 * @return the product
	 */
	@Override
	public Product insertProduct(Product product) {
		return productRepository.save(product);
	}

	/**
	 * Delete product.
	 *
	 * @param id the id
	 */
	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
		
	}

	/**
	 * Update product.
	 *
	 * @param product the product
	 * @return the product
	 */
	@Override
	public Product updateProduct(Product product) {
		Product pResult = null;
		if (productRepository.findById(product.getId()).isPresent()) 
			pResult = productRepository.save(product);
		return pResult;
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the product
	 */
	@Override
	public Product findById(int id) {
		return productRepository.findById(id).orElse(null);
	}

}
