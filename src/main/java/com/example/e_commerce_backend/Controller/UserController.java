package com.example.e_commerce_backend.Controller;

import com.example.e_commerce_backend.DTO.ApiResponse;
import com.example.e_commerce_backend.Model.User;
import com.example.e_commerce_backend.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = {"http://localhost:4200", "http://e-commerce-front-beta.vercel.app"})
@CrossOrigin(origins = {"*"})
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//    @CrossOrigin(origins = {"http://localhost:4200", "http://e-commerce-front-beta.vercel.app"})
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addUser(@RequestBody User user){
        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        this.userService.addUser(user);
        return ResponseEntity.ok(new ApiResponse("User added successfully"));
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            String encodedHash = Base64.getEncoder().encodeToString(hash);
            return encodedHash;
        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
            return null;
        }
    }
//    @CrossOrigin(origins = {"http://localhost:4200", "http://e-commerce-front-beta.vercel.app"})
    @PostMapping("/login")
    public ResponseEntity<Optional<User>> login(@RequestBody User userData){
        Optional<User> user= this.userService.getUserByEmail(userData.getEmail());
        if (user.isPresent()) {
            // Hash the password provided by the user
            String hashedPassword = hashPassword(userData.getPassword());

            // Compare the hashed password with the hashed password stored in the database
            if (user.get().getPassword().equals(hashedPassword)) {
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

    }
}
