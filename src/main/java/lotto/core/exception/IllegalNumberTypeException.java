package lotto.core.exception;

public class IllegalNumberTypeException extends LottoApplicationException {
    private static final String DEFAULT_MESSAGE = "반드시 숫자만 입력하셔야 합니다.";

    public IllegalNumberTypeException() {
        super(DEFAULT_MESSAGE);
    }
}
