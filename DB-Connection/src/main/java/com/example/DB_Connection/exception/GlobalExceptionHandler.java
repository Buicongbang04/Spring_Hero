package com.example.DB_Connection.exception;

import com.example.DB_Connection.dto.request.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<APIResponse> handlingException(Exception e) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<APIResponse> handlingAppException(AppException e) {
        ErrorCode errorCode = e.getErrorCode();
        APIResponse apiResponse = new APIResponse();
        apiResponse.setMessage(errorCode.getMessage());
        apiResponse.setCode(errorCode.getCode());

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<APIResponse> handlingMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String enumKey = e.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.INVALID_KEY;

        try {
            errorCode = ErrorCode.valueOf(enumKey);
        } catch (IllegalArgumentException ex) {

        }

        APIResponse apiResponse = new APIResponse();
        apiResponse.setMessage(errorCode.getMessage());
        apiResponse.setCode(errorCode.getCode());
        return ResponseEntity.badRequest().body(apiResponse);
    }
}
