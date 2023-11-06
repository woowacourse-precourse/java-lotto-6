package lotto.exception;

public class ThousandCheckException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 1000원 단위로 돈을 넣어 주세요.";

    public ThousandCheckException() {
        super(ERROR_MESSAGE);
    }
}
