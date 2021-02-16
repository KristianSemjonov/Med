package com.medilog.demo.medilog;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MedErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError>handleException(Exception e){
        ResponseError error = new ResponseError();
        error.setMessage("Ilmnes viga");
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST );
    }
    @ExceptionHandler (MedException.class)
    public ResponseEntity<Object>handleMyException(MedException me) {
        ResponseError error = new ResponseError();
        error.setMessage("Vea teavitus");
        return new ResponseEntity<Object>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
