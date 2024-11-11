package com.englishlearning.user_service.Dto;

import com.englishlearning.user_service.Entity.OurUser;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReqRes {
    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private String name;
    private String address;
    private String role;
    private String email;
    private String password;
    private String id;
    private String schoolId;
    private String schoolName;
    private String schoolAddress;
    private String schoolEmail;
    private OurUser ourUser;
    private List<OurUser> ourUserList;
}
