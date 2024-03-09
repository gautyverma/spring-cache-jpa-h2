package com.matuga.springcachejpah2.service;

import com.matuga.springcachejpah2.model.Product;
import com.matuga.springcachejpah2.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  public static final String HASH_KEY = "Product";
  @Autowired ProductRepository productRepository;

  @Autowired private RedisTemplate template;

  // Find All
  public List<Product> findAll() {
    //    return productRepository.findAll();
    return template.opsForHash().values(HASH_KEY);
  }

  // Create Product
  public Product save(Product product) {
    //    return productRepository.save(product);
    template.opsForHash().put(HASH_KEY, product.getId(), product);
    return product;
  }

  // Get by Id
  //  @Cacheable(key = "#productId", value = "Product")
  public Product findByProductId(Integer productId) {
    //    productRepository.findById(productId);
    System.out.println("called findProductById() from DB");
    return (Product) template.opsForHash().get(HASH_KEY, productId);
  }

  // Delete By Id
  public String deleteByProductId(Integer productId) {
    //    productRepository.deleteById(productId);
    template.opsForHash().delete(HASH_KEY, productId);
    return "ProductID - " + productId + " successfully deleted";
  }
}
