package lotto.excpetion;

import static lotto.excpetion.constant.ExceptionMessage.NOT_IN_RANGE;

public class NotInRageException extends IllegalArgumentException{
    public NotInRageException() {
        super(NOT_IN_RANGE.getMessage());
    }
}
