package com.br.letscode.databaseproject.shared.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code =  HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<MessageError> handlerBadRequests(MethodArgumentNotValidException exception){
        List<MessageError> errors = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String errorMessage = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            MessageError MessageError = new MessageError(e.getField(), errorMessage);
            errors.add(MessageError);
        });
        return errors;
    }

    @ResponseStatus(code =  HttpStatus.CONFLICT)
    @ExceptionHandler(ConflictError.class)
    public List<MessageError> handlerConflictRequest(ConflictError exception){
        return List.of(exception.getMessageError());
    }

    @ResponseStatus(code =  HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundError.class)
    public List<MessageError> handlerNotFoundRequest(NotFoundError exception){
        return List.of(exception.getMessageError());
    }

}
