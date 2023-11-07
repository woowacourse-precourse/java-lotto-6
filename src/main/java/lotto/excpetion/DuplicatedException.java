package lotto.excpetion;

import static lotto.excpetion.constant.ExceptionMessage.DUPLICATED_NUMBER;

public class DuplicatedException extends IllegalArgumentException{
    public DuplicatedException() {
        super(DUPLICATED_NUMBER.getMessage());
    }
}
