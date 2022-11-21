package com.ykw.exception;

public class ProductItemNotFoundException extends RuntimeException {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public ProductItemNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public ProductItemNotFoundException() {
        super();
    }
}
