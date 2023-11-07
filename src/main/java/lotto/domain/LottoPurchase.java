package lotto.domain;

import lotto.domain.constant.LottoConstant;
import lotto.domain.exception.ExceptionMessage;

public class LottoPurchase {

    private final long purchaseAmount;

    public LottoPurchase(long purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validatePurchaseAmount(long purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NON_POSITIVE_PURCHASE_AMOUNT);
        }

        if (purchaseAmount % LottoConstant.LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVISIBLE_BY_LOTTO_TICKET_PRICE);
        }
    }

    public long countTickets() {
        return purchaseAmount / LottoConstant.LOTTO_TICKET_PRICE;
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }
}
