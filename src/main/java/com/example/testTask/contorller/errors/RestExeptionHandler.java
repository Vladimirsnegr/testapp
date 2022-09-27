package com.example.testTask.contorller.errors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.annotation.Priority;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
public class RestExeptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> sQLIntegrityConstraintViolationException(HttpServletRequest httpServletRequest, SQLIntegrityConstraintViolationException exception) {
        String error = "Нарушена уникальность: "+ exception.getLocalizedMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, error));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> entityNotFoundException(HttpServletRequest httpServletRequest, EntityNotFoundException exception) {
        String error = "Не найден дочерний элемент: " + exception.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.NOT_FOUND, error));
    }

    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    public ResponseEntity<Object> invalidDataAccessApiUsageException(HttpServletRequest httpServletRequest, InvalidDataAccessApiUsageException exception) {
        String error = "Переданное значение не соответствует типу данных поля: " + exception.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, error));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> runtimeException(HttpServletRequest httpServletRequest, RuntimeException exception) {
        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

    private ResponseEntity<Object> buildResponseEntity (ErrorResponse errorResponse) {
        return new ResponseEntity<Object>(errorResponse,errorResponse.getStatus());
    }
}
