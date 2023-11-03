package lotto.exception;

public class NullInputException extends IllegalArgumentException {
    private final static String NULL_INPUT = "입력값이 공백입니다.";

    public NullInputException() {
        super(NULL_INPUT);
    }
}
