package com.kaushik.bookstore.service;

import com.kaushik.bookstore.entity.Role;
import com.kaushik.bookstore.entity.User;
import com.kaushik.bookstore.exception.UserNotFoundException;
import com.kaushik.bookstore.model.AuthenticationRequest;
import com.kaushik.bookstore.model.AuthenticationResponse;
import com.kaushik.bookstore.model.UserModel;
import com.kaushik.bookstore.model.UserResponse;
import com.kaushik.bookstore.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    @Override
    public AuthenticationResponse registerUser(UserModel userModel) {
        User user = new User();
        UserResponse userResponse = new UserResponse();
        modelMapper.map(userModel, user);
        modelMapper.map(user, userResponse);
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setRole(Role.USER);
        var userPresent = userRepository.findByEmail(userModel.getEmail());
        if (userPresent.isPresent()) {
            throw new RuntimeException("Email Already Exists");
        } else {
            userRepository.save(user);
        }
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .user(userResponse)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));
        UserResponse userResponse = new UserResponse();
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
        modelMapper.map(user, userResponse);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .user(userResponse)
                .build();
    }


}
