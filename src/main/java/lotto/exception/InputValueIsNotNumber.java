package lotto.exception;

public class InputValueIsNotNumber extends Throwable {
    private static final String ERROR_MESSAGE = "[ERROR] 입력 값이 숫자가 아닙니다.";

    public InputValueIsNotNumber() {
        super(ERROR_MESSAGE);
    }
}
