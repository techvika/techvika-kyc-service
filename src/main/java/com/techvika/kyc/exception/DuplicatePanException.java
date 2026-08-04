package com.techvika.kyc.exception;

public class DuplicatePanException extends RuntimeException {
    public DuplicatePanException(String message) {
        super(message);
    }

    public DuplicatePanException(String message, Throwable cause) {
        super(message, cause);
    }
}
