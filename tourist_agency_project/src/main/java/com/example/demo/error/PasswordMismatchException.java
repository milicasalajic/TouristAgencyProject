package com.example.demo.error;

import org.apache.coyote.BadRequestException;

public class PasswordMismatchException extends BadRequestException {
    public PasswordMismatchException(String message)  {
        super(message);
    }
}
