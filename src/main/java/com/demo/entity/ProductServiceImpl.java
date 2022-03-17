package com.demo.entity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;
    

    @Override
    public  List<Product> getAllProducts(){
        return repository.findAll();

    }

    @Override
    public void saveProduct(Product product) {
        this.repository.save(product);
                
    }

    @Override
    public Product getProductById(long id) {
     Optional<Product> optional =repository.findById(id);
     Product product =null;
     if(optional.isPresent()){
         product = optional.get();
     }else{
         throw new 
        
         RuntimeException("Product not found for id::" +id);
     }
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        
        return repository.save(product);
    }

    @Override
    public Product deleteProductById(long id) {
            
        Product product =repository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid Product Id " + id));
        repository.delete(product);
        return product;    
        
    }
    
    @Override
    public Page<Product> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
        return this.repository.findAll(pageable);
    }
                
      
        
        

}
