package com.kaushik.bookstore.service;

import com.kaushik.bookstore.entity.User;
import com.kaushik.bookstore.model.AuthenticationRequest;
import com.kaushik.bookstore.model.AuthenticationResponse;
import com.kaushik.bookstore.model.UserModel;

public interface UserService {
    AuthenticationResponse registerUser(UserModel userModel);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
