package lotto.exception;

public class NonNumericAmountException extends LottoGameException {

    private static final String MESSAGE = "구입 금액은 숫자로 입력 해야 합니다.";

    public NonNumericAmountException() {
        super(MESSAGE);
    }
}
