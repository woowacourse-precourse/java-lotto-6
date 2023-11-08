package lotto.exception.lotto;

public class LottoRangeException extends IllegalArgumentException {
    private static final String LOTTO_NUMBER_RANGE_MSG = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public LottoRangeException() {
        super(LOTTO_NUMBER_RANGE_MSG);
    }
}
