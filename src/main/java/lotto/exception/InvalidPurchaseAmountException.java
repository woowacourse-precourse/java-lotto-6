package lotto.exception;

public class InvalidPurchaseAmountException extends IllegalArgumentException {

    private static final String INVALID_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";

    public InvalidPurchaseAmountException() {
        super(INVALID_PURCHASE_AMOUNT);
    }
}
