package lotto.exception;

public class NotNumbersFormatException extends IllegalArgumentException {
    private static final String MESSAGE = "숫자와 쉼표(,)만 입력해 주세요. 예) 1,2,3,4,5,6";

    public NotNumbersFormatException() {
        super(MESSAGE);
    }
}
