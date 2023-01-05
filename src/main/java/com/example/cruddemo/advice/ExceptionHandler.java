package com.example.cruddemo.advice;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.entity.ErrorDetails;
import org.springframework.boot.autoconfigure.template.TemplateLocation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
@RestController
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers,HttpStatus status, WebRequest request) {

        List<Object> details = new ArrayList<>();

        for (ObjectError error : e.getBindingResult().getAllErrors()) {

            details.add(error.getDefaultMessage());

        }
        return new ResponseEntity<>(new ErrorDetails("400", "Validation Failed", details), HttpStatus.BAD_REQUEST);
    }


}