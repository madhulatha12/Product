package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.demo.Product;
import com.product.service.ProductService;
@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping("/product")
	public Product insertproduct(@RequestBody Product p) {
		return service.addProduct(p);
		
		
	}
	@GetMapping("/product")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
		
	}
	@PutMapping("/product")
	public Product updateproduct(@RequestBody Product p) {
		return service.addProduct(p);
		
	}
	@DeleteMapping("/product/{id}")
	public Product deleteproduct(@PathVariable("id") int id) {
		return service.deleteProduct(id);
		

}
}
	
	
	


