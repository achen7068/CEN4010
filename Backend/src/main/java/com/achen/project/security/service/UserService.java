package com.achen.project.security.service;


import com.achen.project.security.dto.SignUpRequest;

public interface    UserService {

    void save(final SignUpRequest request);
}
