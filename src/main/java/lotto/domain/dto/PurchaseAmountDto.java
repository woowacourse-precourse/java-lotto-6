package lotto.domain.dto;

import lotto.validator.PurchaseAmountValidator;

public record PurchaseAmountDto(int amount) {
    public static final int PURCHASE_AMOUNT_UNIT = 1_000;

    public PurchaseAmountDto {
        PurchaseAmountValidator.validatePurchaseAmount(amount);
    }

    public int purchaseQuantityLottos() {
        return amount / PURCHASE_AMOUNT_UNIT;
    }
}
