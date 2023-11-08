package lotto.exception;

public class NumberNotInRangeException extends LottoException {
    private static final String ERROR_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public NumberNotInRangeException() {
        super(ERROR_MESSAGE);
    }
}
