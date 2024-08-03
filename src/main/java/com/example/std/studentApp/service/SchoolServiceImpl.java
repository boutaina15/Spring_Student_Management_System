package com.example.std.studentApp.service;

import com.example.std.studentApp.dao.SchoolRepository;
import com.example.std.studentApp.entity.School;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    @Override
    public void deleteSchool(Long schoolId) {
        boolean exists = schoolRepository.existsById(schoolId);
        if (!exists) {
            throw new IllegalStateException("school with id " + schoolId + " does not exist");
        }
        schoolRepository.deleteById(schoolId);
        System.out.println("the school with id: " + schoolId + " has been deleted successfully");
    }

    @Override
    public void addSchool(School school) {
        schoolRepository.save(school);
        System.out.println("the school: " + school + " has been added successfully");
    }

    @Override
    @Transactional
    public School updateSchool(Long schoolId, School schoolreq) {
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new IllegalStateException("school with id " + schoolId + " does not exist"));

        school.setSchoolName(schoolreq.getSchoolName());
        school.setEmail(schoolreq.getEmail());
        System.out.println("the school with id: " + schoolId + " has been updated successfully");

        return schoolRepository.save(school);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public School getSchoolById(Long schoolId) {
        return schoolRepository.findById(schoolId)
                .orElseThrow(() -> new IllegalStateException("school with id " + schoolId + " does not exist"));
    }
}
