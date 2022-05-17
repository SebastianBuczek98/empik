package com.example.s_buczek_empik.web;

import com.example.s_buczek_empik.model.ErrorDetails;
import com.example.s_buczek_empik.model.exception.GithubClientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * ----------------------------
 * Created by Sebastian Buczek
 * ----------------------------
 */

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(GithubClientException.class)
    public ResponseEntity<?> handleGithubClientException(GithubClientException githubClientException, WebRequest webRequest) {
        return new ResponseEntity<>(new ErrorDetails(LocalDateTime.now(), githubClientException.getMessage(), webRequest.getDescription(false)), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
