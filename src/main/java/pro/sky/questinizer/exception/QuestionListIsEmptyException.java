package pro.sky.questinizer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class QuestionListIsEmptyException extends RuntimeException{
    public QuestionListIsEmptyException(String message) {
        super(message);
    }

    public QuestionListIsEmptyException() {
        super();
    }
}
