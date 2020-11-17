package com.achen.project.security.controller;


import com.achen.project.security.dto.RoleRequest;
import com.achen.project.security.dto.RoleResponse;
import com.achen.project.security.repository.entity.Role;
import com.achen.project.security.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@CrossOrigin
public class RoleController {

    RoleService roleService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleResponse> createRole(@Valid @RequestBody final RoleRequest request) {
        final Role role = roleService.save(request.getName());
        RoleResponse response = new RoleResponse();
        response.setId(role.getId());
        response.setName(role.getName());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
