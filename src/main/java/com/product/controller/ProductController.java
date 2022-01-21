package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.demo.Product;
import com.product.exception.ProductNotFoundException;
import com.product.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Object> getProduct(@PathVariable("id") int id ) { 
	  Product p= service.getProduct(id);
	  
	  if(p==null)
		  throw new ProductNotFoundException();
	   return new ResponseEntity<>(p, HttpStatus.OK);
	 }
	@PostMapping("/product")
	public ResponseEntity<Object> insertproduct(@RequestBody Product p)
	  {
		Product p1= service.addProduct(p);
		if(p1==null)
			  throw new ProductNotFoundException();
		   return new ResponseEntity<>("product added sucessfully", HttpStatus.OK);
	 
	 
	 }
	@PutMapping("/product") 
	public ResponseEntity<Object> updateproduct(@RequestBody Product p)
	  { 
	     Product p1=service.updateProduct(p);
	     if(p1==null)
			  throw new ProductNotFoundException();
		   return new ResponseEntity<>("product updated sucessfully", HttpStatus.OK);
	 
	 
	 }
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Object> deleteproduct(@PathVariable("id") int id) 
	{ 
	     Product p1=service.deleteProduct(id);
	     if(p1==null)
			  throw new ProductNotFoundException();
		   return new ResponseEntity<>("product deleted sucessfully", HttpStatus.OK);
	 
	 
	 }
	  
	  }
	
	
	
	

	

	


