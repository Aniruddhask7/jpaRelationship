package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "student_jpa")
public class Student {

    @Id
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private  Department department;

}
