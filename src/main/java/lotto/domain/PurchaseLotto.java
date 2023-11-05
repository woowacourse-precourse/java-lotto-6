package lotto.domain;

import lotto.constant.ErrorMessages;

import static lotto.constant.NumberConstants.*;

public class PurchaseLotto {

    private final int purchaseAmount;

    public PurchaseLotto(int purchaseAmount) {
        isAvailableNumber(purchaseAmount);
        isLegalValue(purchaseAmount);
        isDivisible(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void isAvailableNumber(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.NEGATIVE_AMOUNT.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private void isLegalValue(int purchaseAmount) {
        if (purchaseAmount > LEGAL_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.ILLEGAL_AMOUNT.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private void isDivisible(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.INVALID_AMOUNT.getMessage() +
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
