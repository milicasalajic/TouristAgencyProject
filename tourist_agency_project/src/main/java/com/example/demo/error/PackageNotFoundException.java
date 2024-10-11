package com.example.demo.error;

import org.apache.coyote.BadRequestException;

public class PackageNotFoundException extends BadRequestException {//ResourceNotFoundException
    public PackageNotFoundException(String message)  {
        super(message);
    }
}
