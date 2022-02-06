package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity(name = "Student")
@Table(
  name = "student",
  uniqueConstraints = {
    @UniqueConstraint(columnNames = "email", name = "student_email_unique")
  }
)
public class Student {
  @Id
  @SequenceGenerator(
    name ="student_sequense",
    sequenceName = "student_sequense",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "student_sequense"
  )
  private Long id;
  private String name;
  @Transient
  private Integer age;
  private LocalDate dob;
  private String email;

  public Student(){

  }
  
  public Student(
    Long id,
    String name,
    LocalDate dob,
    String email
  ){
    this.id = id;
    this.name = name;
    this.email = email;
    this.dob = dob;
  }

  public Student(
    String name,
    LocalDate dob,
    String email
  ){
    this.name = name;
    this.email = email;
    this.dob = dob;
  }
  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return Period.between(this.dob, LocalDate.now()).getYears();
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public LocalDate getDob() {
    return this.dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", name='" + getName() + "'" +
      ", age='" + getAge() + "'" +
      ", dob='" + getDob() + "'" +
      ", email='" + getEmail() + "'" +
      "}";
  }
}
