package com.jo.trainrecallbackend.controllers;

import com.jo.trainrecallbackend.models.Test;
import com.jo.trainrecallbackend.models.User;
import com.jo.trainrecallbackend.payload.request.TestRequest;
import com.jo.trainrecallbackend.repositories.TestRepository;
import com.jo.trainrecallbackend.repositories.UserRepository;
import com.jo.trainrecallbackend.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private TestRepository testRepo;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/test/{testName}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Collection<Test> returnTest(@PathVariable String testName) {

        UserDetailsImpl userDetails =
                (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = userDetails.getId();

        return testRepo.findByUserId(userId).stream().filter(t -> t.getNameOfTest().equals(testName)).toList();
    }

    @PostMapping("/test")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String postTest(@Valid @RequestBody TestRequest testRequest) {

        UserDetailsImpl userDetails =
                (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userRepo.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Test test = new Test(testRequest.getNameOfTest(),
                            testRequest.getSetting(),
                            testRequest.getScore(),
                            testRequest.getDateOfTest(),
                            user);
        testRepo.save(test);
        return "Test Saved";
    }

    @GetMapping("data")
    public String getData() {
        return "Hello World";
    }
}