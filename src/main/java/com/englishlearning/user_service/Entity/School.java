package com.englishlearning.user_service.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "School")
@Data
public class School {
    @Id
    private String id;
    private String name;
    private String email;
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OurUser> users;
}