package com.examly.springapp.service;

import com.examly.springapp.model.Application;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.ApplicationRepository;
import com.examly.springapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;

    // Create application
    public Application createApplication(Long userId, Application application) {
        User applicant = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        application.setApplicant(applicant);
        return applicationRepository.save(application);
    }

    // Get all applications
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    // Get applications by applicant
    public List<Application> getApplicationsByUser(Long userId) {
        User applicant = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return applicationRepository.findByApplicant(applicant);
    }

    // Approve application
    public Application approveApplication(Long appId, String comments) {
        Application app = applicationRepository.findById(appId)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        app.setStatus(Application.Status.APPROVED);
        app.setComments(comments);
        return applicationRepository.save(app);
    }

    // Reject application
    public Application rejectApplication(Long appId, String comments) {
        Application app = applicationRepository.findById(appId)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        app.setStatus(Application.Status.REJECTED);
        app.setComments(comments);
        return applicationRepository.save(app);
    }
}
