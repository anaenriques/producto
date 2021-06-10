/*
 * Product's Service
 * @author: sinsajoTeam
 * @version: v1.0
 */

package com.producto.service;

import java.util.List;

import com.producto.model.Product;

public interface ProductServiceI {
	List<Product> listAllProducts();
	Product insertProduct(final Product product);
	void deleteProduct(final int id);
	Product updateProduct(final Product product);
	Product findById(final int id);
}
