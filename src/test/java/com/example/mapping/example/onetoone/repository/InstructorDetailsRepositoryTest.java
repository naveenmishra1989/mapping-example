package com.example.mapping.example.onetoone.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.mapping.example.onetoone.entity.InstructorDetails;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class InstructorDetailsRepositoryTest {

  @Autowired
  private  InstructorDetailsRepository instructorDetailsRepository;

  @Test
  void diDirectional(){
    final List<InstructorDetails> instructorDetails = instructorDetailsRepository.findAll();
    System.out.println(instructorDetails);
  }

}