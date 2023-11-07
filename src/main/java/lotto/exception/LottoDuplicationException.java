package lotto.exception;

public class LottoDuplicationException extends RuntimeException {
    private static final String MESSAGE = "로또 번호는 중복될 수 없습니다.";

    public LottoDuplicationException() {
        super(MESSAGE);
    }
}
