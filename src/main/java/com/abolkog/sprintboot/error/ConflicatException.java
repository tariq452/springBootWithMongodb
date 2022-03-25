package com.abolkog.sprintboot.error;

import org.springframework.http.HttpStatus;

public class ConflicatException extends ApiBaseException{
    public ConflicatException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
