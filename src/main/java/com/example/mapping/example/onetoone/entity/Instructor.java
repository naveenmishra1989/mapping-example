package com.example.mapping.example.onetoone.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@TableGenerator(name="tab", initialValue=10001, allocationSize=50)
public class Instructor {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE,generator = "tab")
  private Integer id;
  private String name;

  @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  @JoinColumn(name = "fk_InstructorDetails")
  private InstructorDetails instructorDetails; //foreign key of fk_Instructor
}
