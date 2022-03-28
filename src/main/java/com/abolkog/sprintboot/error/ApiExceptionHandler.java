package com.abolkog.sprintboot.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<ErrorDetails> handleApiException(ApiBaseException ex, WebRequest request){
        ErrorDetails details = new ErrorDetails(ex.getMessage(),request.getDescription(true));
        return new ResponseEntity<>(details,ex.getStatusCode());
    }
//this method to return list error example when the filed is Mandatory
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
       ValidationError validationError=new ValidationError();
       validationError.getUri(request.getDescription(false));

        List<FieldError> fieldErrors =ex.getBindingResult().getFieldErrors();
        for (FieldError f: fieldErrors){
            validationError.addError(f.getDefaultMessage());


        }return new ResponseEntity<>(validationError,HttpStatus.BAD_REQUEST);

    }


}
