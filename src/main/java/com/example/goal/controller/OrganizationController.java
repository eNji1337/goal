package com.example.goal.controller;

import com.example.goal.entity.Organization;
import com.example.goal.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrganizationController {

    @Autowired
    OrganizationRepository organizationRepository;

    @PostMapping("/org/assign")
    public ResponseEntity<Organization> assignEmpToOrg(@RequestBody Organization organization) {
        return new ResponseEntity<>(
                organizationRepository.save(organization),
                HttpStatus.CREATED);
    }
}
