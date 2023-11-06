package lotto.dto;

import lotto.exception.ExceptionMessage;

public class LottoPurchaseRequest {

    private int purchaseAmount;

    public LottoPurchaseRequest(String purchaseAmount) {
        try {
            this.purchaseAmount = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_FORMAT);
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
