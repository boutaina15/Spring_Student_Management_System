package com.example.std.studentApp.service;

import com.example.std.studentApp.entity.School;

import java.util.List;

public interface SchoolService {

    void deleteSchool(Long schoolId);
    void addSchool(School school);
    School updateSchool(Long schoolId, School schoolreq);
    List<School> getAllSchools();
    School getSchoolById(Long schoolId);
}
