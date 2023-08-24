package com.example.mapping.example.onetoone.repository;

import com.example.mapping.example.onetoone.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {


}
