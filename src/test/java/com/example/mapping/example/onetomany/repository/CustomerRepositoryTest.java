package com.example.mapping.example.onetomany.repository;

import com.example.mapping.example.onetomany.entity.Customer;
import com.example.mapping.example.onetomany.entity.Product;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CustomerRepositoryTest {

  @Autowired
  private CustomerRepository repository;

  @Test
  void findAll() {
    final List<Customer> customers = repository.findAll();
    for (Customer customer : customers) {
      System.out.println(customer);
      final List<Product> products = customer.getProducts();
      products.forEach(product -> {
        System.out.println(product);
      });
    }
  }


}