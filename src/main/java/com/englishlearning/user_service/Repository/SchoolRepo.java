package com.englishlearning.user_service.Repository;

import com.englishlearning.user_service.Entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<School, String> {
    School findByName(String name);
}