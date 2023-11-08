package lotto.exception;

public class InputException extends IllegalArgumentException {
    private static final String PREFIX_MESSAGE = "[ERROR]";
    public static final String INPUT_ERROR_MESSAGE = "잘못 된 입력 입니다.";

    public InputException() {
        super(String.format("%s %s", PREFIX_MESSAGE, INPUT_ERROR_MESSAGE));
    }
}
