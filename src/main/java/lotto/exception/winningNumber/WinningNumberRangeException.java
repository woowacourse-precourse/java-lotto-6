package lotto.exception.winningNumber;

public class WinningNumberRangeException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다.";

    public WinningNumberRangeException() {
        super(ERROR_MESSAGE);
    }
}
