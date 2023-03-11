package com.gabrieldragone.springmongodb.exceptions

import com.gabrieldragone.springmongodb.dtos.ErrorDTO
import com.mongodb.MongoWriteException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(MongoWriteException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMongoWriteException(
        exception: MongoWriteException,
        request: HttpServletRequest
        ): ErrorDTO {
        return ErrorDTO(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = exception.message,
            path = "[${request.method}] ${request.servletPath}"
        )
    }

    @ExceptionHandler(EmailJaCadastradoException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleEmailJaCadastradoException(
        exception: EmailJaCadastradoException,
        request: HttpServletRequest
    ): ErrorDTO {
        return ErrorDTO(
            status = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = exception.message,
            path = "[${request.method}] ${request.servletPath}"
        )
    }



}