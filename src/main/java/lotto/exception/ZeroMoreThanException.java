package lotto.exception;

public class ZeroMoreThanException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 돈을 1000원 이상으로 넣어 주세요.";

    public ZeroMoreThanException() {
        super(ERROR_MESSAGE);
    }
}
