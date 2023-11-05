package lotto.exception;

public class DuplicatedLottoException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE =
            CommonExceptionMessage.PREFIX_EXCEPTION.getMessage() + "로또 번호는 중복되지 않아야 합니다.";

    public DuplicatedLottoException() {
        super(ERROR_MESSAGE);
    }
}