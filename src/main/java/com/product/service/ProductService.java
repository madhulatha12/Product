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
	
public Product updateProduct(Product p) {
		
		return repo.save(p);
	}
	
	public List<Product> getAllProducts(){
		
		return (List<Product>)repo.findAll();
		
	}
	
	public Product deleteProduct(int id) {
		
			Product p=repo.findById(id).get();
			repo.deleteById(id);
			return p;
		}
		
		//System.out.println("address="+address);
		//Product p=null;
		//try {
			// p=repo.findById(address).get();
			
	//	}
		//catch(Exception e) {
		//	throw new ProductNotFoundException("address:"+address);
			
		
		//}
		
		//System.out.println("p="+p);
	//	if(p!=null)
	//	repo.deleteById(address);
		//return p;
	


	public Product getProduct(int id) {
		
		return repo.findById(id).orElse(null);
	}


	


	
	}

