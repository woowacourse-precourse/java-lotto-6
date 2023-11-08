package lotto.exception.game;

public class OutOfRangeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

    public OutOfRangeException() {
        super(ERROR_MESSAGE);
    }
}
