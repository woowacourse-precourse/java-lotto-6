package lotto.domain;

public class PurchaseAmount {
    public static final int PURCHASE_AMOUNT_UNIT = 1_000;
    public static final String PURCHASE_AMOUNT_NOT_DIVISIBLE_MESSAGE =
            "구입 금액은 " + PURCHASE_AMOUNT_UNIT + "단위로 입력해 주세요.";
    private final int amount;

    public PurchaseAmount(final int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.amount = purchaseAmount;
    }

    private void validatePurchaseAmount(final int amount) {
        validatePurchaseAmountUnit(amount);
    }

    private void validatePurchaseAmountUnit(final int amount) {
        if (amount % PURCHASE_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_DIVISIBLE_MESSAGE);
        }
    }

    public int getAmount() {
        return amount;
    }
}
