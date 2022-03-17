package com.demo.entity;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
	 
    @Autowired
    private ProductService service;

    Logger logger=LoggerFactory.getLogger(ProductController.class);

    //display list of products
    @RequestMapping("/")
    public String viewHomepage(Model model){
        return findPaginated(1, model);

    }
       
    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model){
      
        Product product=new Product();
        model.addAttribute("product", product);
        logger.info("adding a new product..");
        return "new_product";

    }
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product,RedirectAttributes redirectattribute){
        
        service.saveProduct(product);
        redirectattribute.addFlashAttribute("message","Product added successfully!");
        logger.info("saving a product");
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id ,Model model){
        
        Product product = service.getProductById(id);
        
        model.addAttribute("product",product);         
        return "update_product";

    }
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id,
                                @ModelAttribute("product")Product product,
                                RedirectAttributes redirectAttributes){

    
    Product existingProduct= service.getProductById(id);
    existingProduct.setId(id);
    existingProduct.setProductName(product.getProductName());
   
    existingProduct.setPrice(product.getPrice());

  
    service.updateProduct(existingProduct);
    logger.info("product updated..");
    redirectAttributes.addFlashAttribute("message", "product updated successfully");
    return "redirect:/";
                                }
    
    @GetMapping("/DeleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") long id, Model model ,RedirectAttributes redirectattribute){

        
        Product product = service.deleteProductById(id);
        model.addAttribute("product", product);
        redirectattribute.addFlashAttribute("message","Product deleted successfully!");  
        logger.info("deleting the product..");
        return "redirect:/";
               
        

    }
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model){
        int pageSize = 5;
        Page<Product> page = service.findPaginated(pageNo, pageSize);
        List<Product> listProducts=page.getContent();

        model .addAttribute("currentPage",pageNo);
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("totalItems",page.getTotalElements());
        model.addAttribute("listProducts",listProducts);
        return "index";

    }
    }