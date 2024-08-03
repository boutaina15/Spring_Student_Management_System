package com.example.std.studentApp.controller;

import com.example.std.studentApp.entity.Student;
import com.example.std.studentApp.service.SchoolServiceImpl;
import com.example.std.studentApp.service.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

        private final StudentServiceImpl studentServiceImpl;


        @GetMapping
        @CrossOrigin(origins ="http://localhost:4200")
        public List<Student> getStudents() {
            return studentServiceImpl.getStudents();
        }

        @PostMapping("/add")
        @CrossOrigin(origins ="http://localhost:4200")
        public ResponseEntity<Student> addStudent(@RequestBody Student student) {
                return ResponseEntity.ok(studentServiceImpl.addStudent(student)) ;
        }

        @CrossOrigin(origins ="http://localhost:4200")
        @DeleteMapping("/delete/{studentId}")
        public void deleteStudent(@PathVariable("studentId") Long studentId) {
            studentServiceImpl.deleteStudent(studentId);
        }

        @CrossOrigin(origins ="http://localhost:4200")
        @PutMapping("/update/{studentId}")
        public ResponseEntity<Student> updateStudent(@PathVariable("studentId") Long studentId, @RequestBody Student student) {
           return ResponseEntity.ok(studentServiceImpl.updateStudent(studentId, student)) ;
        }
}
