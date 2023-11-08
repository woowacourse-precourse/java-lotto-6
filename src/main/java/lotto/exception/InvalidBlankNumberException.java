package lotto.exception;

public class InvalidBlankNumberException extends IllegalArgumentException {

    private static final String INVALID_BLANK_NUMBER_MESSAGE = "[ERROR] 로또 숫자 중 비어있는 값이 있습니다.";

    public InvalidBlankNumberException() {
        super(INVALID_BLANK_NUMBER_MESSAGE);
    }
}
