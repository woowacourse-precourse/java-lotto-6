package lotto.exception;

import static lotto.constants.ErrorMessage.ERROR_PREFIX;

import lotto.constants.ErrorMessage;

public class ConsumerException extends IllegalArgumentException {
    private ConsumerException(String message) {
        super(ERROR_PREFIX.getMessage() + message);
    }

    public static ConsumerException of(ErrorMessage errorConstant) {
        return new ConsumerException(errorConstant.getMessage());
    }
}
