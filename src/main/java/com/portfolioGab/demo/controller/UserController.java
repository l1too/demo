
package com.portfolioGab.demo.controller;

import com.portfolioGab.demo.model.User;
import com.portfolioGab.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
    
    @Autowired
    private UserRepository userRepo;
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User userData){
        User user = userRepo.findByUserId(userData.getUserId());
        if(user.getPassword().equals(userData.getPassword()))
            return ResponseEntity.ok(user);
        return (ResponseEntity<?>)ResponseEntity.internalServerError();
    }
}
