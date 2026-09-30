package com.JobAppBackend.JobApp.controller;

import com.JobAppBackend.JobApp.entity.Application;
import com.JobAppBackend.JobApp.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "http://localhost:5173")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public Application applyForJob(@RequestBody Application application) {
        return applicationService.applyForJob(application);
    }

    @GetMapping("/user/{userId}")
    public List<Application> getUserApplications(@PathVariable Long userId) {
        return applicationService.getApplicationsByJobSeeker(userId);
    }

    @GetMapping("/job/{jobId}")
    public List<Application> getJobApplications(@PathVariable Long jobId) {
        return applicationService.getApplicationsByJob(jobId);
    }
}