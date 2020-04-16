package com.gala.shop.util.exception;

/**
 * This exception is thrown to indicate that the record is not found
 */

public class NotFoundAppException extends RuntimeException {
    public NotFoundAppException(String message) {
        super(message);
    }
}
