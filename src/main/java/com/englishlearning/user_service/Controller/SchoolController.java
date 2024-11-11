package com.englishlearning.user_service.Controller;

import com.englishlearning.user_service.Dto.ReqRes;
import com.englishlearning.user_service.Entity.School;
import com.englishlearning.user_service.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/admin/add-school")
    public ResponseEntity<ReqRes> addSchool(@RequestBody ReqRes reqRes) {
        return ResponseEntity.ok(schoolService.addSchool(reqRes));
    }

    @GetMapping("/admin/get-all-schools")
    public ResponseEntity<List<School>> getAllSchools() {
        return ResponseEntity.ok(schoolService.getAllSchools());
    }


    @GetMapping("/admin/get-school/{schoolId}")
    public ResponseEntity<ReqRes> getSchoolById(@PathVariable String schoolId) {
        return ResponseEntity.ok(schoolService.getSchoolById(schoolId));
    }

    @PutMapping("/admin/update-school/{schoolId}")
    public ResponseEntity<ReqRes> updateSchool(@PathVariable String schoolId, @RequestBody ReqRes reqRes) {
        return ResponseEntity.ok(schoolService.updateSchool(schoolId, reqRes));
    }

    @DeleteMapping("/admin/delete/{schoolId}")
    public ResponseEntity<ReqRes> deleteSchool(@PathVariable String schoolId) {
        return ResponseEntity.ok(schoolService.deleteSchool(schoolId));
    }
}
