package lotto.core.exception;

public class IllegalNumberRangeException extends LottoApplicationException {

    private static final String DEFAULT_MESSAGE =
            "수의 범위를 벗어났습니다. 다시 입력해 주세요.";

    public IllegalNumberRangeException() {
        super(DEFAULT_MESSAGE);
    }
}
