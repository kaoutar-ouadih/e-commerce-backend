package com.example.e_commerce_backend.Service;

import com.example.e_commerce_backend.Model.User;
import com.example.e_commerce_backend.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void addUser(User user) {
        this.userRepo.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
       return this.userRepo.findUserByEmail(email);
    }
}
