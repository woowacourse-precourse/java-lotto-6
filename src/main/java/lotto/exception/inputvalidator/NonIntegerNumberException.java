package lotto.exception.inputvalidator;

import lotto.exception.CustomException;

public class NonIntegerNumberException extends CustomException {

    private static final String message = "[ERROR] : 당첨 번호는 정수입니다.";

    public NonIntegerNumberException() {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}