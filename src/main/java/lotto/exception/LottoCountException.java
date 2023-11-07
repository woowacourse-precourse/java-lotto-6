package lotto.exception;

public class LottoCountException extends RuntimeException {
    public LottoCountException() {
        super("로또 번호는 6개여야 합니다.");
    }
}
