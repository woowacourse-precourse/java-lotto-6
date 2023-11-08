package lotto.exception.argument;

/**
 * 로또 번호가 1~45 범위의 값이 아닐 경우에 대한 예외
 */
public class LottoNumericRangeException extends BaseIllegalArgumentException {
    private static final String MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public LottoNumericRangeException() {
        super(MESSAGE);
    }
}
