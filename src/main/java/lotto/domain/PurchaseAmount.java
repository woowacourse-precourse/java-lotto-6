package lotto.domain;

import lotto.Utils;
import lotto.exception.ExceptionMessage;

import static lotto.Constants.DIVIDE_UNIT;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(String input) {
        int inputAmount = Utils.convertStringToInt(input);
        validate(inputAmount);
        this.amount = inputAmount;
    }

    public int calculateLottoCount() {
        return amount / DIVIDE_UNIT;
    }

    public double calculateProfit(long prizeSum) {
        return (1.0 * prizeSum / amount) * 100;
    }

    private void validate(int inputAmount) {
        validateNaturalNumber(inputAmount);
        validateDivideUnit(inputAmount);
    }

    private void validateNaturalNumber(int inputAmount) {
        if (inputAmount < 1) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER.get());
        }
    }

    private void validateDivideUnit(int inputAmount) {
        if (inputAmount % DIVIDE_UNIT != 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVIDE_UNIT.get(DIVIDE_UNIT));
        }
    }
}
