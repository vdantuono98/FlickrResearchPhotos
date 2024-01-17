package com.vindan.dev.flickrresearchphotos.api;

import java.io.IOException;

public class ApiException extends IOException {

    private int statusCode;
    private String errorMessage;

    public ApiException(int statusCode, String errorMessage) {
        super(errorMessage);
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
