package com.kaushik.bookstore.controller;

import com.kaushik.bookstore.model.AuthenticationRequest;
import com.kaushik.bookstore.model.AuthenticationResponse;
import com.kaushik.bookstore.model.UserModel;
import com.kaushik.bookstore.service.UserService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/auth")
@RestController
@RequiredArgsConstructor
@Tag(
        name = "Authentication",
        description = "Here, POST all details of User and generate Bearer Authentication Token."
)
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    @Hidden
    public ResponseEntity<AuthenticationResponse> register(
           @Valid @RequestBody UserModel request
    ) {
        return ResponseEntity.ok(userService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
           @Valid @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(userService.authenticate(request));
    }
}
