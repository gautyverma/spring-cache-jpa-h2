package com.matuga.springcachejpah2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringCacheJpaH2Application {

  public static void main(String[] args) {
    SpringApplication.run(SpringCacheJpaH2Application.class, args);
  }
}
