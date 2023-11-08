package lotto.domain;

import static common.enumtype.ErrorCode.AMOUNT_INVALID_UNIT;
import static common.enumtype.ErrorCode.AMOUNT_LESS_THAN_MINIMUM;

import common.exception.InvalidArgumentException;

public class LottoPurchaseAmount {

    private static final int MINIMUM_MONEY = 1000;
    private static final int UNIT_AMOUNT = 1000;
    private static final int REST_AMOUNT = 0;
    private final int amount;

    public LottoPurchaseAmount(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public int getLottoCount() {
        return amount / UNIT_AMOUNT;
    }

    public int getAmount() {
        return amount;
    }

    private void validateAmount(int amount) {
        if (!isAboveMinimum(amount)) {
            throw new InvalidArgumentException(AMOUNT_LESS_THAN_MINIMUM);
        }

        if (!isValidUnit(amount)) {
            throw new InvalidArgumentException(AMOUNT_INVALID_UNIT);
        }
    }

    private boolean isAboveMinimum(int amount) {
        return amount >= MINIMUM_MONEY;
    }

    private boolean isValidUnit(int amount) {
        return (amount % UNIT_AMOUNT) == REST_AMOUNT;
    }
}
