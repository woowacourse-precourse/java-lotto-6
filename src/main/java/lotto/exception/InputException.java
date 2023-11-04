package lotto.exception;

public class InputException extends IllegalArgumentException{
    public InputException(ExceptionType exceptionType){
        super(exceptionType.getValue());
    }
}
