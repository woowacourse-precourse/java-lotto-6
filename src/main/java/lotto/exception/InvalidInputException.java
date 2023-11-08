package lotto.exception;

public class InvalidInputException extends IllegalArgumentException{
    public InvalidInputException(String exceptionCode) {
        super(exceptionCode);
    }
}
