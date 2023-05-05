package com.kaushik.bookstore.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserNotFoundException extends RuntimeException{
    private String message;

    public UserNotFoundException(String message){
        super(message);
        this.message = message;
    }

}
