package lotto.domain;

import static lotto.exception.ErrorMessage.PURCHASE_AMOUNT_IS_NEGATIVE_NUMBER;
import static lotto.exception.ErrorMessage.PURCHASE_AMOUNT_IS_LESS_THAN_MINIMUM_AMOUNT;
import static lotto.exception.ErrorMessage.PURCHASE_AMOUNT_IS_NOT_DIVIDED_UNIT_AMOUNT;
import static lotto.constraint.PurchaseAmountConstraint.*;

import lotto.exception.InputException;

public class Player {
    private final int DIVIDED_REMAINDER = 0;
    private final int purchaseAmount;
    private final int gameCount;

    private Player(int purchaseAmount) {
        validate(purchaseAmount);

        this.purchaseAmount = purchaseAmount;
        gameCount = makeGameCount(purchaseAmount);
    }

    public static Player from(int purchaseAmount) {
        return new Player(purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getGameCount() {
        return gameCount;
    }

    private void validate(int purchaseAmount) {
        validateNegativeNumber(purchaseAmount);
        validateLessThanMinimumAmount(purchaseAmount);
        validateDividedByUnitAmount(purchaseAmount);
    }

    private void validateNegativeNumber(int purchaseAmount) {
        if (isNegativeNumber(purchaseAmount)) {
            throw InputException.from(PURCHASE_AMOUNT_IS_NEGATIVE_NUMBER);
        }
    }

    private void validateLessThanMinimumAmount(int purchaseAmount) {
        if (isLessThanMinimumAmount(purchaseAmount)) {
            throw InputException.from(PURCHASE_AMOUNT_IS_LESS_THAN_MINIMUM_AMOUNT);
        }
    }

    private void validateDividedByUnitAmount(int purchaseAmount) {
        if (!isDividedByUnitAmount(purchaseAmount)) {
            throw InputException.from(PURCHASE_AMOUNT_IS_NOT_DIVIDED_UNIT_AMOUNT);
        }
    }

    private boolean isNegativeNumber(int purchaseAmount) {
        return purchaseAmount < POSITIVE_THRESHOLD.getValue();
    }

    private boolean isLessThanMinimumAmount(int purchaseAmount) {
        return purchaseAmount < MINIMUM_PURCHASE_UNIT_AMOUNT.getValue();
    }

    private boolean isDividedByUnitAmount(int purchaseAmount) {
        return purchaseAmount % MINIMUM_PURCHASE_UNIT_AMOUNT.getValue() == DIVIDED_REMAINDER;
    }

    private int makeGameCount(int purchaseAmount) {
        return purchaseAmount / MINIMUM_PURCHASE_UNIT_AMOUNT.getValue();
    }
}