package lotto.core.exception;

public class IllegalLottoSizeException extends LottoApplicationException {
    private static final String DEFAULT_MESSAGE = "로또 번호는 6자리 입니다.";

    public IllegalLottoSizeException() {
        super(DEFAULT_MESSAGE);
    }
}
