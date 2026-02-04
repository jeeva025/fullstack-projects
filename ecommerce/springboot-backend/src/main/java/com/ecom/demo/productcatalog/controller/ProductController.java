package com.ecom.demo.productcatalog.controller;

import com.ecom.demo.productcatalog.model.Product;
import com.ecom.demo.productcatalog.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsById(@PathVariable Long categoryId){
        return productService.getProductByCategory(categoryId);
    }
}
