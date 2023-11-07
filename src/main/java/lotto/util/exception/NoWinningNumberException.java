package lotto.util.exception;

public class NoWinningNumberException extends IllegalStateException {
    private static final String message = "입력된 당첨번호가 없습니다.";

    public NoWinningNumberException() {
        super(message);
    }
}
