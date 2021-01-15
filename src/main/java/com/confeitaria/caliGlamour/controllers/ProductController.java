package com.confeitaria.caliGlamour.controllers;

import com.confeitaria.caliGlamour.entities.Product;
import com.confeitaria.caliGlamour.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;


    @GetMapping("/products")
    public ResponseEntity<List<Product>> listAll() {
        List<Product> products = repository.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/productsNames")
    public ResponseEntity<Map<String,Long>> listNames() {
        List<Product> products = repository.findAll();
        List<String> productsNames = new ArrayList<>();
        products.forEach(p -> { productsNames.add(p.getName());});

        Map<String,Long> productLongMap = new HashMap<>();
        products.forEach(p -> productLongMap.put(p.getName(),p.getId()));
        System.out.println(productLongMap);
        return ResponseEntity.ok().body(productLongMap);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return repository.save(product);
    }

}
