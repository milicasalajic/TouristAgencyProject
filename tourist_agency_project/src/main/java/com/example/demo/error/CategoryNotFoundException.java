package com.example.demo.error;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException (String message)  {
        super(message);
    }
}
