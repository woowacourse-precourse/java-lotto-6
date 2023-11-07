package lotto.exception;

public class LottoDuplicateException extends RuntimeException {
    private static final String MESSAGE = "로또 번호는 중복될 수 없습니다.";

    public LottoDuplicateException() {
        super(MESSAGE);
    }
}
