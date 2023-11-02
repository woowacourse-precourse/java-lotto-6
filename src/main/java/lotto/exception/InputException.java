package lotto.exception;

public class InputException extends IllegalArgumentException {
    private static final String PREFIX_MESSAGE = "[ERROR]";

    public InputException() {
        super(String.format("%s %s", PREFIX_MESSAGE, "잘못 된 입력 입니다."));
    }
}
