package com.example.productsservice.controller;

import com.example.productsservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List> getAllProducts(){
        return ResponseEntity.ok(productService.get_all_products());
    }


}
