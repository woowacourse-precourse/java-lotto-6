package lotto.exception;

public class InvalidWinningNumbersException extends IllegalArgumentException {

    private static final String INVALID_WINNING_NUMBERS = "[ERROR] 당첨 번호가 잘못 입력되었습니다.";

    public InvalidWinningNumbersException() {
        super(INVALID_WINNING_NUMBERS);
    }
}
