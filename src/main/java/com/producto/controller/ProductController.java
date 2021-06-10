package com.producto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.producto.model.Product;
import com.producto.service.ProductServiceI;

@RestController
public class ProductController {
	
	/** The product service. */
	@Autowired
	@Qualifier("ProductServiceImpl")
	private ProductServiceI productService;

	/**
	 * List all products.
	 *
	 * @return List of products
	 */
	@GetMapping("/listAllProducts")
	public List<Product> listAllClients() {
		return productService.listAllProducts();
	}

}
