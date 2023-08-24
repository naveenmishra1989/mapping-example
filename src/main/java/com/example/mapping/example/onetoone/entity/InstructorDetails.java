package com.example.mapping.example.onetoone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class InstructorDetails {
  @Id
  @GeneratedValue
  private Integer id;
  private String gender;
  private String hobby;

  @ToString.Exclude  //exclude toString method to avoid StackFlowError at runtime
  @OneToOne(mappedBy = "instructorDetails")
  private Instructor instructor;//no extra column
}
