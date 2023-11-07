package lotto.exception;

public class LottoNumberRangeException extends RuntimeException {
    private static final String MESSAGE = "[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.";

    public LottoNumberRangeException() {
        super(MESSAGE);
    }
}
