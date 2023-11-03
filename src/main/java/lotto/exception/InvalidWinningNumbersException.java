package lotto.exception;

public class InvalidWinningNumbersException extends IllegalArgumentException {

    public static final String INVALID_WINNING_NUMBERS_SIZE = "[ERROR] 당첨 번호가 잘못되었습니다.";

    public InvalidWinningNumbersException() {
        super(INVALID_WINNING_NUMBERS_SIZE);
    }
}
