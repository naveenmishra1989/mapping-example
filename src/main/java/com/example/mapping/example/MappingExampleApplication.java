package com.example.mapping.example;

import com.example.mapping.example.onetomany.entity.Customer;
import com.example.mapping.example.onetomany.entity.Product;
import com.example.mapping.example.onetomany.repository.CustomerRepository;
import com.example.mapping.example.onetoone.entity.Instructor;
import com.example.mapping.example.onetoone.entity.InstructorDetails;
import com.example.mapping.example.onetoone.repository.InstructorRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@Log4j2
@SpringBootApplication
@ConfigurationProperties(prefix = "spring.datasource")
public class MappingExampleApplication {
    private String name;
    @Value(value = "${spring.datasource.name}")
    private String value;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    public static void main(String[] args) {
        SpringApplication.run(MappingExampleApplication.class, args);
    }

    @PostConstruct
    public void init() {
        final Customer customer = customerRepository.save(getCustomer());
        System.out.println("Record saved: " + customer);
        final List<Instructor> instructor = instructorRepository
            .saveAll(Arrays.asList(getInstructor(), getInstructor1()));
        System.out.println("Record saved: " + instructor);
      customer.getProducts().forEach(product -> System.out.println(product+" "+product.getCustomer()));

    }

    private Customer getCustomer() {
        final Customer customer = Customer.builder()
            .gender("M")
            .name("naveen")
            .build();
        //First Approach
        /*final Product tv = Product.builder().name("TV").customer(customer).build();
        final Product lapTop = Product.builder().name("LapTop").customer(customer).build();
        final Product shoes = Product.builder().name("Shoes").customer(customer).build();*/
      //  customer.setProducts(Arrays.asList(tv, lapTop, shoes));//save foreign as well
        final Product tv = Product.builder().name("TV").build();
        final Product lapTop = Product.builder().name("LapTop").build();
        final Product shoes = Product.builder().name("Shoes").build();
        //Second Approach
        customer.addProduct(tv,lapTop,shoes);
        return customer;
    }

    private Instructor getInstructor() {
        return Instructor.builder()
            .name("naveen")
            .instructorDetails(InstructorDetails.builder()
                .gender("M")
                .hobby("Coding")
                .build())
            .build();
    }

    private Instructor getInstructor1() {
        return Instructor.builder()
            .name("sarita")
            .instructorDetails(InstructorDetails.builder()
                .gender("F")
                .hobby("wondering")
                .build())
            .build();
    }

    @Bean
    public CommandLineRunner run(){
        log.info(name+"   "+value);
        log.warn(name+"   "+value);
        log.error(name+"   "+value);
        return (agrs-> System.out.println("Command line rummer"));
    }


}
