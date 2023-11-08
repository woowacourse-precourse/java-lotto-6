package lotto.exception;

public class InvalidLottoNumberRangeException extends IllegalArgumentException {
    private static final String INVALID_LOTTO_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public InvalidLottoNumberRangeException() {
        super(INVALID_LOTTO_RANGE);
    }
}
