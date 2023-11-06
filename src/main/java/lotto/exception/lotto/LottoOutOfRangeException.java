package lotto.exception.lotto;

public class LottoOutOfRangeException extends IllegalArgumentException {
    private static final String ERROR_MSG = "[ERROR] 로또 번호는 1 이상 45 이하여야 합니다.";

    public LottoOutOfRangeException() {
        super(ERROR_MSG);
    }
}


