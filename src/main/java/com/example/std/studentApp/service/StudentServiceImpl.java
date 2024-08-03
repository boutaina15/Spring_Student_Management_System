package com.example.std.studentApp.service;


import com.example.std.studentApp.dao.SchoolRepository;
import com.example.std.studentApp.dao.StudentRepository;
import com.example.std.studentApp.entity.School;
import com.example.std.studentApp.entity.Student;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

     private final StudentRepository studentRepository;



     public List<Student> getStudents(){
          return studentRepository.findAll();
}

     public Student addStudent(Student student) {
          return studentRepository.save(student);
     }

     public void deleteStudent(Long studentId) {
         boolean exists = studentRepository.existsById(studentId);
         if (!exists) {
              throw new IllegalStateException("student with id " +studentId+" does not exists");
         }
         studentRepository.deleteById(studentId);
         System.out.println("the student with id : "+studentId+ " has been deleted succefully");

     }

     @Transactional
     public Student updateStudent(Long studentId, Student studentreq) {
         Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with id "+ studentId+" does not exists"));
        if (student != null){
         student.setName(studentreq.getName());
         student.setBirth(studentreq.getBirth());
         System.out.println("the student with id : "+studentId+ " has been updated succefully");

        }
        return studentRepository.save(student);


     }

}


