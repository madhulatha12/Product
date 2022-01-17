package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.demo.Product;
import com.product.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	public Product addProduct(Product p) {
		return repo.save(p);
	}
	public List<Product> getAllProducts(){
		return (List<Product>)repo.findAll();
	}
	public Product deleteProduct(int address) {
		Product p=repo.findById(address).get();
		repo.deleteById(address);
		return p;
	}
}
