package lotto.core.exception;

public class IllegalDuplicateException extends LottoApplicationException {
    private static final String DEFAULT_MESSAGE = "번호는 중복되지 말아야 합니다.";

    public IllegalDuplicateException() {
        super(DEFAULT_MESSAGE);
    }
}
