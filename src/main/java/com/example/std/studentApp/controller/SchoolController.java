package com.example.std.studentApp.controller;

import com.example.std.studentApp.entity.School;
import com.example.std.studentApp.entity.Student;
import com.example.std.studentApp.service.SchoolServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolServiceImpl schoolServiceImpl;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public List<School> getAllSchools() {
        System.out.print("get all schools");
        return schoolServiceImpl.getAllSchools();
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @GetMapping("{schoolId}")
    public ResponseEntity<School> getSchoolById(@PathVariable("schoolId") Long schoolId) {
        School school = schoolServiceImpl.getSchoolById(schoolId);
        return ResponseEntity.ok(school);
    }

    @PostMapping("/add")
    @CrossOrigin(origins ="http://localhost:4200")
    public void addSchool(@RequestBody School school){
        schoolServiceImpl.addSchool(school);
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @DeleteMapping("/delete/{schoolId}")
    public void deleteSchool(@PathVariable("schoolId") Long schoolId) {
        schoolServiceImpl.deleteSchool(schoolId);
    }

    @CrossOrigin(origins ="http://localhost:4200")
    @PutMapping("/update/{schoolId}")
    public ResponseEntity<School> updateSchool(@PathVariable("schoolId") Long schoolId, @RequestBody School school) {
        return ResponseEntity.ok(schoolServiceImpl.updateSchool(schoolId, school)) ;
    }
}
