package lotto.exception;

import static lotto.constants.ErrorConstants.ERROR_PREFIX;

import lotto.constants.ErrorConstants;

public class ConsumerException extends IllegalArgumentException {
    private ConsumerException(String message) {
        super(ERROR_PREFIX.getMessage() + message);
    }

    public static ConsumerException of(ErrorConstants errorConstant) {
        return new ConsumerException(errorConstant.getMessage());
    }
}
