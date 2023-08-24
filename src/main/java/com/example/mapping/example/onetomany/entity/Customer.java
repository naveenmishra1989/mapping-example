package com.example.mapping.example.onetomany.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String name;
  private String gender;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  private List<Product> products; //no extra column in Customer table

  public void addProduct(Product... product) {  //logic to add foreign key
    if (product != null) {
      if (products == null) {
        products = new ArrayList<>(product.length);//size of array based on input
      }
      for (Product product1 : product) {
        product1.setCustomer(this);
        products.add(product1);
      }
    }
  }


}
