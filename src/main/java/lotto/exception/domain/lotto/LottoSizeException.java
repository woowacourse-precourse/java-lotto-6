package lotto.exception.domain.lotto;

public class LottoSizeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 로또에 6개 번호가 입력되지 않았습니다.";

    public LottoSizeException() {
        super(ERROR_MESSAGE);
    }
}
