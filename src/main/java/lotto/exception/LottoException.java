package lotto.exception;

public class LottoException extends IllegalArgumentException {
    private static final String PREFIX_MESSAGE = "[ERROR]";

    public LottoException(ErrorMessage message) {
        super(String.format("%s %s", PREFIX_MESSAGE, message.getMessage()));
    }
}
