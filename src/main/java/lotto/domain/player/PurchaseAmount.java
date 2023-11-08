package lotto.domain.player;

public class PurchaseAmount {

    private Integer purchaseAmount;

    private PurchaseAmount(Integer purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount create(Integer purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    private static void validatePurchaseAmount(Integer purchaseAmount) {
        validatePurchaseUnit(purchaseAmount);
    }

    private static void validatePurchaseUnit(Integer purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위이어야 합니다.");
        }
    }

    public static int calculatePurchasedLottoCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    public Integer getPurchaseAmount() {
        return purchaseAmount;
    }
}
