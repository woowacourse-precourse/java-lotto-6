package lotto.dto;

import lotto.constant.LottoConstant;
import lotto.exception.InvalidPurchaseAmountException;

public record PurchaseAmountRequest(Integer purchaseAmount) {

    public PurchaseAmountRequest {
        validatePurchaseAmount(purchaseAmount);
    }

    private void validatePurchaseAmount(Integer purchaseAmount) {
        if (isNotPurchaseAmountPositive(purchaseAmount)) {
            throw new InvalidPurchaseAmountException();
        }

        if (canNotDivideByLottoPrice(purchaseAmount)) {
            throw new InvalidPurchaseAmountException();
        }
    }

    private Boolean canNotDivideByLottoPrice(Integer purchaseAmount) {
        return purchaseAmount % LottoConstant.LOTTO_PRICE.getValue()
            != LottoConstant.ZERO.getValue();
    }

    private Boolean isNotPurchaseAmountPositive(Integer purchaseAmount) {
        return purchaseAmount <= LottoConstant.ZERO.getValue();
    }
}
