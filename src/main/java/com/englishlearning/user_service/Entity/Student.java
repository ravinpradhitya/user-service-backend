package com.englishlearning.user_service.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Student")
@Data
public class Student {

    @Id
    private String id;

    private String name;
    private String email;
    private String password;
    private String address;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
