package lotto.domain;

public class PurchaseAmount {

    private static final int LOTTO_PRICE = 1000;
    private static final int DIVIDE_UP_VALUE = 0;
    private final int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        validatePurchaseAmountUnderThousand(purchaseAmount);
        validatePurchaseAmountDivideByThousand(purchaseAmount);
    }

    private void validatePurchaseAmountDivideByThousand(int purchaseAmount) {
        if(purchaseAmount % LOTTO_PRICE != DIVIDE_UP_VALUE) {
            throw new IllegalArgumentException("[ERROR] : 로또 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    private void validatePurchaseAmountUnderThousand(int purchaseAmount) {
        if(purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] : 로또 구입 금액은 1000 이상의 정수입니다.");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
