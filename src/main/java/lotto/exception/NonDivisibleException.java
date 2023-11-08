package lotto.exception;

public class NonDivisibleException extends IllegalArgumentException {
    private static final String NON_DIVISIBLE_MESSAGE = "[ERROR] 나누어 떨어지지 않는 금액입니다.";

    public NonDivisibleException() {
        super(NON_DIVISIBLE_MESSAGE);
    }
}
