package lotto.exception.inputvalidator;

import lotto.exception.CustomException;

public class NonNumericInputException extends CustomException {

    private static final String message = "[ERROR] : 문자가 아닌 숫자를 입력해주세요.";

    public NonNumericInputException() {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}

