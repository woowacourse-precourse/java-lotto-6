package lotto.exception;

public class RangeLottoException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE =
            CommonExceptionMessage.PREFIX_EXCEPTION.getMessage() + "로또 번호의 번위는 1 ~ 45 입니다.";

    public RangeLottoException() {
        super(ERROR_MESSAGE);
    }
}
