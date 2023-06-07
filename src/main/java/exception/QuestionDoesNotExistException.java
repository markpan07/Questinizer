package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class QuestionDoesNotExistException extends RuntimeException {

    public QuestionDoesNotExistException() {
    }

    public QuestionDoesNotExistException(String message) {
        super(message);
    }
}
