package lotto.model;

public class PurchaseAmount {

    private static final int MIN_PURCHASE_AMOUNT = 1000;
    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private static final int ZERO = 0;
    private static final String PURCHASE_AMOUNT_RANGE_ERROR_MESSAGE = "[ERROR] 구입 금액 입력의 최솟값은 1000입니다.";
    private static final String PURCHASE_AMOUNT_UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000단위로 입력해야 합니다.";

    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validateRange(purchaseAmount);
        validateUnit(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validateRange(int purchaseAmount) {
        if (purchaseAmount < MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_RANGE_ERROR_MESSAGE);
        }
    }

    private void validateUnit(int purchaseAmount) {
        if ((purchaseAmount % PURCHASE_AMOUNT_UNIT) != ZERO) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERROR_MESSAGE);
        }
    }
}
