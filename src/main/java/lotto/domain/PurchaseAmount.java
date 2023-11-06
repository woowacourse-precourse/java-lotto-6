package lotto.domain;

public class PurchaseAmount {

    private Integer purchaseAmount;

    public PurchaseAmount(Integer purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    private static void validatePurchaseAmountDigit(String purchaseAmount) {
        if (purchaseAmount.chars()
                .anyMatch(ch -> !Character.isDigit(ch))) {
            throw new IllegalArgumentException("구입 금액은 정수이어야 합니다.");
        }
    }
}
