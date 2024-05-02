package com.online.platform.learning.payload.request;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignupRequest {

    private String username;
    private String email;
    private String address;
    private String fullName;
    private String matricule;
    private String caisse;
    private String phoneNumber;
    private String password;
    private String status;
    private Set<String> roles;

}
