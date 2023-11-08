package lotto.util.exception;

public class BlankInputException extends IllegalArgumentException {
    private static final String INPUT_IS_BLANK = "[ERROR] 빈값을 입력하면 안됩니다.";

    public BlankInputException() {
        super(INPUT_IS_BLANK);
    }
}
