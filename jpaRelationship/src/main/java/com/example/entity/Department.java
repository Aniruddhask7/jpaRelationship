package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "department_jpa")
public class Department {

   @Id
   private long id;
   private String name;
}
