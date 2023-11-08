package lotto.excpetion;

import static lotto.excpetion.constant.ExceptionMessage.NOT_NUMBER;

public class NotNumberException extends IllegalArgumentException{
    public NotNumberException() {
        super(NOT_NUMBER.getMessage());
    }
}
