package lotto.domain;

import static java.lang.Integer.parseInt;

public class PurchaseAmount {

    private Integer purchaseAmount;

    private PurchaseAmount(String purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = parseInt(purchaseAmount);
    }

    public static PurchaseAmount create(String purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    private static void validatePurchaseAmount(String purchaseAmount) {
        validatePurchaseAmountDigit(purchaseAmount);
        validatePurchaseUnit(purchaseAmount);
    }

    private static void validatePurchaseAmountDigit(String purchaseAmount) {
        if (purchaseAmount.chars()
                .anyMatch(ch -> !Character.isDigit(ch))) {
            throw new IllegalArgumentException("구입 금액은 정수이어야 합니다.");
        }
    }

    private static void validatePurchaseUnit(String purchaseAmount) {
        if (parseInt(purchaseAmount) % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위이어야 합니다.");
        }
    }
}
