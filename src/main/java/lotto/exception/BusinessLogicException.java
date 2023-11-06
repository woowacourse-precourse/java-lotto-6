package lotto.exception;

public class BusinessLogicException extends IllegalArgumentException{
    private ExceptionMessage exceptionMessage;
    public BusinessLogicException(ExceptionMessage exceptionMessage){
        super(exceptionMessage.getErrorMessage());
    }
}
