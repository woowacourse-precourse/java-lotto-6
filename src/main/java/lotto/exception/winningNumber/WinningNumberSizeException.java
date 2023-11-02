package lotto.exception.winningNumber;

public class WinningNumberSizeException extends IllegalArgumentException{
    private static final String ERROR_MESSAGE = "[ERROR] 당첨 번호는 6개의 숫자가 필요합니다.";

    public WinningNumberSizeException() {
        super(ERROR_MESSAGE);
    }
}
