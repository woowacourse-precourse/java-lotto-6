package lotto.util.exception;

import lotto.util.ErrorMessage;

public class CustomException extends IllegalArgumentException {
    public CustomException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
