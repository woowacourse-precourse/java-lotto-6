package lotto.domain;

public class PurchaseAmounts {
    private final int LOTTO_PRICE = 1000;

    private int purchaseAmounts;

    public PurchaseAmounts(int purchaseAmounts) {
        validatePurchaseAmounts(purchaseAmounts);
        this.purchaseAmounts = purchaseAmounts;
    }

    private void validatePurchaseAmounts(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 장당 1000원 입니다. 다시 입력해주세요.");
        }
    }
}
