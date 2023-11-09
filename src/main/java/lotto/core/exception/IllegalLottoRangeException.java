package lotto.core.exception;

public class IllegalLottoRangeException extends LottoApplicationException {
    private static final String DEFAULT_MESSAGE = "번호의 값은 1 ~ 45 사이의 정수 입니다.";

    public IllegalLottoRangeException() {
        super(DEFAULT_MESSAGE);
    }
}
