package lotto.exception;

public class LottoCountException extends RuntimeException {
    private static final String MESSAGE = "로또 번호는 6개여야 합니다.";

    public LottoCountException() {
        super(MESSAGE);
    }
}
