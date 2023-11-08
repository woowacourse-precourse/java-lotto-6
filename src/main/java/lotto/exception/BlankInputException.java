package lotto.exception;

import static lotto.domain.enums.ExceptionMessage.INPUT_IS_BLANK;

public class BlankInputException extends IllegalArgumentException {
    public BlankInputException() {
        super(INPUT_IS_BLANK);
    }
}
