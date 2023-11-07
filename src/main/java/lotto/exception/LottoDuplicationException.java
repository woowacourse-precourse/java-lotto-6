package lotto.exception;

public class LottoDuplicationException extends RuntimeException {
    public LottoDuplicationException() {
        super("로또 번호는 중복될 수 없습니다.");
    }
}
