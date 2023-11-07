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
        if (isNotAvailableAmount(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.NEGATIVE_AMOUNT.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private static boolean isNotAvailableAmount(int purchaseAmount) {
        return purchaseAmount <= ZERO;
    }

    private void isLegalValue(int purchaseAmount) {
        if (isIllegalAmount(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.ILLEGAL_AMOUNT.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private static boolean isIllegalAmount(int purchaseAmount) {
        return purchaseAmount > LEGAL_AMOUNT;
    }

    private void isDivisible(int purchaseAmount) {
        if (isNotDivisibleAmount(purchaseAmount)) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.INVALID_AMOUNT.format(LOTTO_PRICE) +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private static boolean isNotDivisibleAmount(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE != ZERO;
    }

    public int calculateLottoCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
