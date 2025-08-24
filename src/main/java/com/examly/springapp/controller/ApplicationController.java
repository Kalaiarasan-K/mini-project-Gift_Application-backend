package com.examly.springapp.controller;

import com.examly.springapp.model.Application;
import com.examly.springapp.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // Create new application (Applicant only)
    @PostMapping("/user/{userId}")
    public ResponseEntity<Application> createApplication(@PathVariable Long userId, @RequestBody Application application) {
        return ResponseEntity.ok(applicationService.createApplication(userId, application));
    }

    // Get all applications (Admin/Reviewer)
    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    // Get applications for a specific user (Applicant)
    @GetMapping("/user/{userId}")
    public List<Application> getApplicationsByUser(@PathVariable Long userId) {
        return applicationService.getApplicationsByUser(userId);
    }

    // Approve application (Reviewer/Admin)
    @PutMapping("/{id}/approve")
    public ResponseEntity<Application> approveApplication(@PathVariable Long id, @RequestBody String comments) {
        return ResponseEntity.ok(applicationService.approveApplication(id, comments));
    }

    // Reject application (Reviewer/Admin)
    @PutMapping("/{id}/reject")
    public ResponseEntity<Application> rejectApplication(@PathVariable Long id, @RequestBody String comments) {
        return ResponseEntity.ok(applicationService.rejectApplication(id, comments));
    }
}
