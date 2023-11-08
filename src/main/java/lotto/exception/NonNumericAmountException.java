package lotto.exception;

public class NonNumericAmountException extends LottoGameException {

    private static final String MESSAGE = "숫자로만 입력 해야 합니다.";

    public NonNumericAmountException() {
        super(MESSAGE);
    }
}
