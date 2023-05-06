package com.kaushik.bookstore.exception;

import com.kaushik.bookstore.model.ResponseModel;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobleExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseModel> userNotFoundException(UserNotFoundException exp) {
        String message = exp.getMessage();
        ResponseModel responseModel = new ResponseModel(message, false);
        return new ResponseEntity<>(responseModel, HttpStatus.NOT_FOUND);
    }

    //    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException exception){
//        Map<String,String> response = new HashMap<>();
//        exception.getBindingResult().getAllErrors()
//                .forEach(error -> {
//                    String fieldName = ((FieldError)error).getField();
//                    String message = error.getDefaultMessage();
//                    response.put(fieldName, message);
//                });
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseModel> exceptionHandler(MethodArgumentNotValidException exception) {
        String message = exception.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .findFirst()
                .orElse(exception.getMessage());
        ResponseModel responseModel = new ResponseModel(message, false);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
   }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseModel> exceptionHandler(Exception exception) {
        String message = exception.getMessage();
        ResponseModel responseModel = new ResponseModel(message, false);
        return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
    }
}
