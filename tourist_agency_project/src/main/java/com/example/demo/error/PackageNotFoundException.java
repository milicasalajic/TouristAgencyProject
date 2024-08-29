package com.example.demo.error;

public class PackageNotFoundException extends RuntimeException {//ResourceNotFoundException
    public PackageNotFoundException(String message)  {
        super(message);
    }
}
