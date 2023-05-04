package com.kaushik.bookstore.service;

import com.kaushik.bookstore.entity.Role;
import com.kaushik.bookstore.entity.User;
import com.kaushik.bookstore.exception.ResourceNotFoundException;
import com.kaushik.bookstore.model.AuthenticationRequest;
import com.kaushik.bookstore.model.AuthenticationResponse;
import com.kaushik.bookstore.model.UserModel;
import com.kaushik.bookstore.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;
    private final ModelMapper modelMapper;

    @Override
    public AuthenticationResponse registerUser(UserModel userModel) {
        User user = new User();
        modelMapper.map(userModel, user);
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


}
