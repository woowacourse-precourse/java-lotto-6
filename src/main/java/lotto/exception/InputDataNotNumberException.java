package lotto.exception;

public class InputDataNotNumberException extends IllegalArgumentException {

    private static final String message = "숫자만 입력할 수 있습니다";

    public InputDataNotNumberException() {
        super(message);
    }
}
