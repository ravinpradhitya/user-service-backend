package com.englishlearning.user_service.Service;

import com.englishlearning.user_service.Entity.School;
import com.englishlearning.user_service.Repository.SchoolRepo;
import com.englishlearning.user_service.Dto.ReqRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    @Autowired
    private SchoolRepo schoolRepo;

    public ReqRes addSchool(ReqRes reqRes) {
        ReqRes response = new ReqRes();
        try {
            School school = new School();
            school.setId(reqRes.getId());
            school.setName(reqRes.getName());
            school.setEmail(reqRes.getEmail());
            school.setAddress(reqRes.getAddress());

            School savedSchool = schoolRepo.save(school);
            response.setStatusCode(200);
            response.setMessage("School added successfully");
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error adding school: " + e.getMessage());
        }
        return response;
    }

    public List<School> getAllSchools() {
        return schoolRepo.findAll();
    }

    public ReqRes getSchoolById(String schoolId) {
        ReqRes response = new ReqRes();
        try {
            School school = schoolRepo.findById(schoolId).orElseThrow(() -> new RuntimeException("School not found"));
            response.setStatusCode(200);
            response.setMessage("School found");
            response.setSchoolId(school.getId());
            response.setSchoolName(school.getName());
            response.setSchoolEmail(school.getEmail());
            response.setSchoolAddress(school.getAddress());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error retrieving school: " + e.getMessage());
        }
        return response;
    }

    public ReqRes updateSchool(String schoolId, ReqRes reqRes) {
        ReqRes response = new ReqRes();
        try {
            School existingSchool = schoolRepo.findById(schoolId).orElseThrow(() -> new RuntimeException("School not found"));
            existingSchool.setName(reqRes.getName());
            existingSchool.setEmail(reqRes.getEmail());
            existingSchool.setAddress(reqRes.getAddress());

            schoolRepo.save(existingSchool);
            response.setStatusCode(200);
            response.setMessage("School updated successfully");
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error updating school: " + e.getMessage());
        }
        return response;
    }

    public ReqRes deleteSchool(String schoolId) {
        ReqRes response = new ReqRes();
        try {
            schoolRepo.deleteById(schoolId);
            response.setStatusCode(200);
            response.setMessage("School deleted successfully");
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error deleting school: " + e.getMessage());
        }
        return response;
    }
}