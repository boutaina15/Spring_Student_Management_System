package com.example.std.studentApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @Column(name= "name")
    private String name;

    @Column(name= "birth")
    private LocalDate birth;

    @Column(name= "age")
    @Transient
    private int age;

    @ManyToOne
    @JoinColumn(name = "school_id", referencedColumnName = "school_id")
    private School school;




    public Student(String name, LocalDate birth) {
        this.name = name;
        this.birth = birth;
    }

    public Integer getAge() {
        if (birth == null) {
            return null;
        }
        return Period.between(birth, LocalDate.now()).getYears();
    }
}
