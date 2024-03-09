package com.matuga.springcachejpah2.repository;

import com.matuga.springcachejpah2.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {}
