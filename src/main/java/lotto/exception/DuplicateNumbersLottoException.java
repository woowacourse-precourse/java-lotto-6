package lotto.exception;

public class DuplicateNumbersLottoException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "로또 번호가 중복 됩니다.";

    public DuplicateNumbersLottoException() {
        super(ERROR_MESSAGE);
    }
}
