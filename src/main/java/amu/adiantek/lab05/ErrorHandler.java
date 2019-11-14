package amu.adiantek.lab05;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(value
            = { IllegalArgumentException.class })
    public ResponseEntity<InternalError> handleArgumentException(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(new InternalError(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    public static class InternalError {
        private final String err;

        InternalError(String err) {
            this.err = err;
        }

        public String getErr() {
            return err;
        }
    }
}
