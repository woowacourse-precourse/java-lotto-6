package lotto.domain;

public class PurchaseAmount {

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
        if(purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] : 로또 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }

    private void validatePurchaseAmountUnderThousand(int purchaseAmount) {
        if(purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] : 로또 구입 금액은 1000 이상의 정수입니다.");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
