package lotto.exception;

public class InputNumberException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 잘못된 금액을 입력하셨습니다.";

    public InputNumberException() {
        super(ERROR_MESSAGE);
    }
}
