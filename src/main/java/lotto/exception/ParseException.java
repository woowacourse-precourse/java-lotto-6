package lotto.exception;

public class ParseException extends IllegalArgumentException {

    private static final String INVALID_INPUT = "[ERROR] 입력값이 잘못되었습니다.";

    public ParseException() {
        super(INVALID_INPUT);
    }
}
