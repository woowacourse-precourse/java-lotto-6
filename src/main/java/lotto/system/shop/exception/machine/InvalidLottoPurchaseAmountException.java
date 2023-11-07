package lotto.system.shop.exception.machine;

public class InvalidLottoPurchaseAmountException extends IllegalArgumentException {

    private static final String INVALID_LOTTO_PURCHASE_AMOUNT_MESSAGE = "[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.";

    public InvalidLottoPurchaseAmountException() {
        super(INVALID_LOTTO_PURCHASE_AMOUNT_MESSAGE);
    }
}
