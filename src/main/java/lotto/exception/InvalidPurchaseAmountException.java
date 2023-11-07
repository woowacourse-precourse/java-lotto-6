package lotto.exception;

public class InvalidPurchaseAmountException extends LottoGameException {

    private static final String MESSAGE = "구입 금액은 1,000원 단위로 입력 해야 합니다.";

    public InvalidPurchaseAmountException() {
        super(MESSAGE);
    }
}
