package lotto.validation;

import lotto.exception.InvalidPaymentAmountException;

public class Validator {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String INVALID_NUMERIC_REGEX = "\\d+";
    public void validateNumeric(String enteredPrice) {
        if (!enteredPrice.matches(INVALID_NUMERIC_REGEX)) {
            throw new InvalidPaymentAmountException(ERROR_MESSAGE + "구입 금액 입력시 숫자(정수)만 입력 가능합니다.");
        }
    }
}
