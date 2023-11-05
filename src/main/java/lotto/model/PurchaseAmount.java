package lotto.model;

public class PurchaseAmount {
    private int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validateIsDivisible(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private static void validateIsDivisible(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해야 합니다.");
        }
    }
}
