package com.medilog.demo.medilog;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MedErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError>handleException(Exception e){
        e.printStackTrace();
        ResponseError error = new ResponseError();
        error.setMessage("Ilmnes viga");
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR );
    }
    @ExceptionHandler (MedException.class)
    public ResponseEntity<ResponseError>handleMedException(MedException me) {
        ResponseError error = new ResponseError();
        error.setMessage(me.getMessage());
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
