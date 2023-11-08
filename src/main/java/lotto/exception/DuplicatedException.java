package lotto.exception;

import static lotto.exception.ExceptionMessage.DUPLICATED_NUMBER;

public class DuplicatedException extends IllegalArgumentException{
    public DuplicatedException() {
        super(DUPLICATED_NUMBER.getMessage());
    }
}
