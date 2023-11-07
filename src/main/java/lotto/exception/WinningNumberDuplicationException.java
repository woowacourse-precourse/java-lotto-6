package lotto.exception;

public class WinningNumberDuplicationException extends RuntimeException {
private static final String MESSAGE = "[ERROR] 당첨 번호에 중복된 숫자가 있습니다.";

    public WinningNumberDuplicationException() {
        super(MESSAGE);
    }
}
