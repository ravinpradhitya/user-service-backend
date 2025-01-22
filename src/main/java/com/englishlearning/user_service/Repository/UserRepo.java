package com.englishlearning.user_service.Repository;

import com.englishlearning.user_service.Entity.OurUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<OurUser, String> {
    Optional<OurUser> findByEmail(String email);

    List<OurUser> findByRole(String role);
}
