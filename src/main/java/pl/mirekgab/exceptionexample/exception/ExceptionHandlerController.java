package pl.mirekgab.exceptionexample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(AppRuntimeException.class)
    public ResponseEntity<ExceptionMessage> handleException(AppRuntimeException exception) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                exception.getCode(),
                exception.getMessage()
        );
        return new ResponseEntity<>(exceptionMessage, mapExceptionMessageCodeToHttpStatus(exception.getCode()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        e.getBindingResult().getFieldErrors().forEach(
                m -> System.out.printf("%s %s%n", m.getField(), m.getDefaultMessage())
        );
        /*
         * tutaj można popracować nad treścią i wstawić listę z polami które nie przeszły walidacji
         */
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                ExceptionMessage.CODE_BAD_REQUEST,
                e.getMessage()
        );
        return new ResponseEntity<>(exceptionMessage, mapExceptionMessageCodeToHttpStatus(exceptionMessage.getCode()));
    }

    private HttpStatus mapExceptionMessageCodeToHttpStatus(int code) {
        return switch (code) {
            case ExceptionMessage.CODE_BAD_REQUEST -> HttpStatus.BAD_REQUEST;
            case ExceptionMessage.CODE_NOT_FOUND -> HttpStatus.NOT_FOUND;
            case ExceptionMessage.CODE_SERVER_ERROR -> HttpStatus.INTERNAL_SERVER_ERROR;
            default -> HttpStatus.OK;
        };
    }
}
