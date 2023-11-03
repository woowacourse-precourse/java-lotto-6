package lotto.exception;

public class InvalidWinningNumberException extends IllegalArgumentException {

    public static final String INVALID_WINNING_NUMBER = "당첨 번호는 1 이상 45 이하여야 합니다.";

    public InvalidWinningNumberException() {
        super(INVALID_WINNING_NUMBER);
    }

    public InvalidWinningNumberException(String s) {
        super(s);
    }
}
