package lotto.domain.dto;

import lotto.domain.PurchaseAmount;

public record PurchaseAmountDto(int amount) {
    public int purchaseQuantityLottos() {
        return amount / PurchaseAmount.PURCHASE_AMOUNT_UNIT;
    }
}
