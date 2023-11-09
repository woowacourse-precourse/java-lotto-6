package lotto.system.shop.exception.reader;

public class InvalidNumberTypeException extends IllegalArgumentException {

    private static final String INVALID_NUMBER_TYPE_MESSAGE = "[ERROR] 수가 아닙니다.";

    public InvalidNumberTypeException() {
        super(INVALID_NUMBER_TYPE_MESSAGE);
    }
}
