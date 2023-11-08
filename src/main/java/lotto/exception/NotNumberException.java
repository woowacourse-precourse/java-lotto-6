package lotto.exception;

import static lotto.exception.ExceptionMessage.NOT_NUMBER;

public class NotNumberException extends IllegalArgumentException{
    public NotNumberException() {
        super(NOT_NUMBER.getMessage());
    }
}