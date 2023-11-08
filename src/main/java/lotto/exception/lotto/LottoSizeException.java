package lotto.exception.lotto;

public class LottoSizeException extends IllegalArgumentException {
    private static final String LOTTO_MAX_SIZE_MSG = "로또 번호는 6개의 숫자여야 합니다.";

    public LottoSizeException() {
        super(LOTTO_MAX_SIZE_MSG);
    }
}
