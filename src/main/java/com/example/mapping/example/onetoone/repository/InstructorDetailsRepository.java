package com.example.mapping.example.onetoone.repository;

import com.example.mapping.example.onetoone.entity.InstructorDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDetailsRepository extends JpaRepository<InstructorDetails,Integer> {

}
