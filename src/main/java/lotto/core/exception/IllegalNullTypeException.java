package lotto.core.exception;

public class IllegalNullTypeException extends LottoApplicationException {
    private static final String DEFAULT_MESSAGE = "값이 NULL 이어서는 안됩니다.";

    public IllegalNullTypeException() {
        super(DEFAULT_MESSAGE);
    }
}
