package lotto.model;

import static lotto.config.LottoConfig.PURCHASE_AMOUNT_VALUE_MIN;
import static lotto.config.LottoConfig.PURCHASE_AMOUNT_VALUE_MAX;
import static lotto.Message.ErrorMessage.PURCHASE_AMOUNT_RANGE_ERROR_MESSAGE;
import static lotto.Message.ErrorMessage.PURCHASE_AMOUNT_UNIT_ERROR_MESSAGE;

public class PurchaseAmount {
    private final int purchaseAmount;
    private final int lottoQuantity;

    public PurchaseAmount(int purchaseAmount) {
        rangeValidate(purchaseAmount);
        unitValidate(purchaseAmount);

        this.purchaseAmount = purchaseAmount;
        this.lottoQuantity = countLottoQuantity(purchaseAmount);
    }

    private void rangeValidate(int purchaseAmount) {
        if (purchaseAmount < PURCHASE_AMOUNT_VALUE_MIN.getValue() || purchaseAmount > PURCHASE_AMOUNT_VALUE_MAX.getValue()) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private void unitValidate(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERROR_MESSAGE.getMessage());
        }
    }

    private int countLottoQuantity(int purchaseAmount) {
        return purchaseAmount / PURCHASE_AMOUNT_VALUE_MIN.getValue();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getLottoQuantity() {
        return lottoQuantity;
    }
}