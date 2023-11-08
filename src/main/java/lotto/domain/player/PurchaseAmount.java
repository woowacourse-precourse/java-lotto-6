package lotto.domain.player;

import static lotto.config.GameConfig.LOTTO_PRICE;
import static lotto.exception.ErrorMessage.PURCHASE_UNIT_INVALID;

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
        if (isPurchaseUnitInvalid(purchaseAmount)) {
            throw new IllegalArgumentException(String.format(
                    PURCHASE_UNIT_INVALID.getMessage(),
                    LOTTO_PRICE.getNumber())
            );
        }
    }

    private static boolean isPurchaseUnitInvalid(Integer purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE.getNumber() != 0;
    }

    public int calculatePurchasedLottoCount(PurchaseAmount purchaseAmount) {
        return purchaseAmount.getPurchaseAmount() / 1000;
    }

    public Integer getPurchaseAmount() {
        return purchaseAmount;
    }
}
