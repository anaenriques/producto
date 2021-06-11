package com.producto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.producto.model.Product;
import com.producto.service.ProductServiceI;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ProductControllerTest {
	
	@Autowired
	@Qualifier("ProductServiceImpl")
	private ProductServiceI productService;

	@Test
	@Order(1)
	void listAllClients() {
		assertEquals(3, productService.listAllProducts().size());
	}
	
	@Test
	@Order(2)
	void listClientById() {
		assertEquals(1, productService.findById(1).getId());
	}
	
	@Test
	@Order(3)
	void addClient() {
		Product product = new Product(4, "", "", "", "", "");
		assertEquals(4, productService.insertProduct(product).getId());
	}
	
	@Test
	@Order(4)
	void updateClient() {
		Product product = new Product(4, "Aguacate", "", "", "", "");
		assertEquals("Aguacate", productService.updateProduct(product).getName());
	}
	
	@Test
	@Order(5)
	void deleteClient() {
		productService.deleteProduct(4);
		assertEquals(3, productService.listAllProducts().size());
	}

}
