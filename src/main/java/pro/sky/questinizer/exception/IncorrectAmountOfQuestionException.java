package pro.sky.questinizer.exception;

public class IncorrectAmountOfQuestionException extends RuntimeException{
    public IncorrectAmountOfQuestionException(){
        super();
    }
    public IncorrectAmountOfQuestionException(String message) {
        super(message);
    }
}
