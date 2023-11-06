package lotto.exception;

public class LottoNumberOutOfRangeException extends LottoGameException {
    private static final String MESSAGE = "로또 번호는 1~45 사이여야 합니다.";

    public LottoNumberOutOfRangeException() {
        super(MESSAGE);
    }
}
