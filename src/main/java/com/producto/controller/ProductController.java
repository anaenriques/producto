/*
 * Product's Controller
 * @author: sinsajoTeam
 * @version: v1.0
 */
package com.producto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.producto.model.Product;
import com.producto.service.ProductServiceI;

/**
 * The Class ProductController.
 */
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
	public List<Product> listAllProducts() {
		return productService.listAllProducts();
	}

	/**
	 * List product by id.
	 *
	 * @param id: Product id
	 * @return Found product
	 */
	@GetMapping("/listProduct/{id}")
	public Product listProductById(@PathVariable int id) {
		return productService.findById(id);
	}

	/**
	 * Adds the product.
	 *
	 * @param product: new product
	 * @return Added Product
	 */
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.insertProduct(product);
	}

	/**
	 * Delete product.
	 *
	 * @param id: Product id
	 * @return Message ok
	 */
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		productService.deleteProduct(id);
		return "Se ha borrado correctamente";
	}

	/**
	 * Update product.
	 *
	 * @param product: updated product
	 * @param id: Product id
	 * @return Update product or null if don't exist
	 */
	@PostMapping("/updateProduct/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable int id) {
		product.setId(id);
		return productService.updateProduct(product);

	}

}
