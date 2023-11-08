package lotto.exception;

public class LottoSizeException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE =
            CommonExceptionMessage.PREFIX_EXCEPTION.getMessage() + "로또는 6개로 이루어져 있습니다";

    public LottoSizeException() {
        super(ERROR_MESSAGE);
    }
}
