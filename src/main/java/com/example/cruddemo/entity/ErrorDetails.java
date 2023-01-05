package com.example.cruddemo.entity;

import java.util.Date;
import java.util.List;

public class ErrorDetails {

        private String status;
        private String message;
        private List<Object> details;

    public ErrorDetails(String s, String validation_failed, List<Object> details) {
        this.status = s;
        this.message = validation_failed;
        this.details = details;

    }
}

