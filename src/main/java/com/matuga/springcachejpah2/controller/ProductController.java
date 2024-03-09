package com.matuga.springcachejpah2.controller;

import com.matuga.springcachejpah2.model.Product;
import com.matuga.springcachejpah2.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
  @Autowired ProductService productService;

  @GetMapping("/product/all")
  List<Product> findAll() {
    return productService.findAll();
  }

  // Create Product
  @PostMapping("/create/product")
  String save(@RequestBody Product product) {
    Product save = productService.save(product);
    return "Product successfully created with id " + save.getId();
  }

  // Get by Id
  @GetMapping("/product/{productId}")
  Product findByProductId(@PathVariable Integer productId) {
    return productService.findByProductId(productId);
  }

  // Delete By Id
  @DeleteMapping("/product/{productId}")
  String deleteByProductId(@PathVariable Integer productId) {
    return productService.deleteByProductId(productId);
  }
}
