package com.platzi.play.web.exception;

import com.platzi.play.domain.exception.MovieAlreadyExistException;
import com.platzi.play.domain.exception.MovieNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistException.class)
    public ResponseEntity<Error> handleException(Exception e) {
        return ResponseEntity.badRequest().body(new Error("movie-already-exist", e.getMessage()));
    }

    @ExceptionHandler(MovieNotFound.class)
    public ResponseEntity<Error> handleException(MovieNotFound e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Error("movie-not-found", e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handlerException(MethodArgumentNotValidException e) {
        List<Error> errors = new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach(error -> {
             errors.add(new Error(error.getField(), error.getDefaultMessage()));
        });

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handlerException(Exception e) {
        return ResponseEntity.internalServerError().body(new Error("unknown-error", e.getMessage()));
    }
}
