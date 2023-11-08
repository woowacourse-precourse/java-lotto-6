package lotto.exception;

import static lotto.exception.ExceptionMessage.NOT_IN_RANGE;

public class NotInRageException extends IllegalArgumentException{
    public NotInRageException() {
        super(NOT_IN_RANGE.getMessage());
    }
}