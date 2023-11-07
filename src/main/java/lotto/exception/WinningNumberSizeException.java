package lotto.exception;

public class WinningNumberSizeException extends RuntimeException {
    private static final String MESSAGE = "[ERROR] 당첨 번호는 6개여야 합니다.";

    public WinningNumberSizeException() {
        super(MESSAGE);
    }
}
