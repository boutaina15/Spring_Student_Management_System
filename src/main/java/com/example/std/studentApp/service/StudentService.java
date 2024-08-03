package com.example.std.studentApp.service;

import com.example.std.studentApp.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();

     void deleteStudent(Long studentId);

     Student updateStudent(Long studentId, Student studentreq);

    Student addStudent(Student student);


}
