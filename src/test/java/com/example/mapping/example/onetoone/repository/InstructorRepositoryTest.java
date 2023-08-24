package com.example.mapping.example.onetoone.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.mapping.example.onetoone.entity.Instructor;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class InstructorRepositoryTest {

  @Autowired
  private InstructorRepository instructorRepository;

  @Test
  void findAll(){
    final List<Instructor> instructors = instructorRepository.findAll();
    System.out.println(instructors);
  }

}