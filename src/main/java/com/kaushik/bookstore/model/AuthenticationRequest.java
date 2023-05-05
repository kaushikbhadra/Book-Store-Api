package com.kaushik.bookstore.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    @NotEmpty
    @Email(message = "email is not valid!")
    private String email;
    @NotEmpty
    @Size(min = 8, max = 12, message = "password size require 8-12")
    private String password;
}
