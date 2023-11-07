package lotto.exception;

public class NumberException extends IllegalArgumentException {
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 구매 금액은 숫자만 입력해야합니다";

    public NumberException() {
        super(NOT_NUMBER_ERROR_MESSAGE);
    }}
