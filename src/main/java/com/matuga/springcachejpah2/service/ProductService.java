package com.matuga.springcachejpah2.service;

import com.matuga.springcachejpah2.model.Product;
import com.matuga.springcachejpah2.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  @Autowired ProductRepository productRepository;

  // Find All
  public List<Product> findAll() {
    return productRepository.findAll();
  }

  // Create Product
  public Product save(Product product) {
    return productRepository.save(product);
  }

  // Get by Id

  public Product findByProductId(Integer productId) {
    Optional<Product> productOptional = productRepository.findById(productId);
    return productOptional.get();
  }

  // Delete By Id
  public String deleteByProductId(Integer productId) {
    productRepository.deleteById(productId);
    return "ProductID - " + productId + " successfully deleted";
  }
}
