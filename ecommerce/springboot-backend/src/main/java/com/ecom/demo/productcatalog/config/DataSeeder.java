package com.ecom.demo.productcatalog.config;

import com.ecom.demo.productcatalog.model.Category;
import com.ecom.demo.productcatalog.model.Product;
import com.ecom.demo.productcatalog.repository.CategoryRepository;
import com.ecom.demo.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


//    @Override
//    public void run(String... args) throws Exception {
//        //Clear all existing data
//        productRepository.deleteAll();
//        categoryRepository.deleteAll();
//
//        //create Categories
//        Category electronics1 = new Category();
//        electronics1.setName("Electronics");
//
//        Category clothing1 = new Category();
//        clothing1.setName("Clothing");
//
//        Category home = new Category();
//        home.setName("Home and Kitchen");
//
//        categoryRepository.saveAll(Arrays.asList(electronics1,home, clothing1));
//
//        //create Products
//        Product phone = new Product();
//        phone.setName("SmartPhone");
//        phone.setDescription("Lastest model smartphone with amazing features");
//        phone.setImageUrl("https://placehold.co/600x400");
//        phone.setPrice(30000.0);
//        phone.setCategory(electronics1);
//
//        Product laptop = new Product();
//        laptop.setName("Laptop");
//        laptop.setDescription("High-performance laptop for work and play");
//        laptop.setImageUrl("https://placehold.co/600x400");
//        laptop.setPrice(90000.2);
//        laptop.setCategory(electronics1);
//
//        Product jacket = new Product();
//        jacket.setName("Winter Jacket");
//        jacket.setDescription("Warm and cozy jacket for winter.");
//        jacket.setImageUrl("https://placehold.co/600x400");
//        jacket.setPrice(5000.4);
//        jacket.setCategory(clothing1);
//
//        Product blender = new Product();
//        blender.setName("Blender");
//        blender.setDescription("High-speed blender for smoothies and more.");
//        blender.setImageUrl("https://placehold.co/600x400");
//        blender.setPrice(5000.4);
//        blender.setCategory(home);
//
//        productRepository.saveAll(Arrays.asList(phone,laptop,jacket,blender));
//
//    }

    @Override
    public void run(String... args) {

        productRepository.deleteAll();
        categoryRepository.deleteAll();

        Category electronics1 = new Category();
        electronics1.setName("Electronics");
        electronics1.setProducts(new HashSet<>());

        Category clothing1 = new Category();
        clothing1.setName("Clothing");
        clothing1.setProducts(new HashSet<>());

        Category home = new Category();
        home.setName("Home and Kitchen");
        home.setProducts(new HashSet<>());

        categoryRepository.saveAll(Arrays.asList(electronics1, home, clothing1));

        Product phone = new Product();
        phone.setName("SmartPhone");
        phone.setDescription("Lastest model smartphone with amazing features");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(30000.0);
        phone.setCategory(electronics1);
        electronics1.getProducts().add(phone);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High-performance laptop for work and play");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(90000.2);
        laptop.setCategory(electronics1);
        electronics1.getProducts().add(laptop);

        Product jacket = new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("Warm and cozy jacket for winter.");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(5000.4);
        jacket.setCategory(clothing1);
        clothing1.getProducts().add(jacket);

        Product blender = new Product();
        blender.setName("Blender");
        blender.setDescription("High-speed blender for smoothies and more.");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(5000.4);
        blender.setCategory(home);
        home.getProducts().add(blender);

        productRepository.saveAll(Arrays.asList(phone, laptop, jacket, blender));
    }

}
