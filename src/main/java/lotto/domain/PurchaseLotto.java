package lotto.domain;

import lotto.constant.ErrorMessages;
import lotto.constant.NumberConstants;

import static lotto.constant.NumberConstants.*;

public class PurchaseLotto {

    private final int purchaseAmount;

    public PurchaseLotto(int purchaseAmount) {
        isAvailableNumber(purchaseAmount);
        isDivisible(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void isAvailableNumber(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.NEGATIVE_AMOUNT +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private void isDivisible(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.INVALID_AMOUNT +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    public int calculateLottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
