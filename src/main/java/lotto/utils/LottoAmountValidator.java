package lotto.utils;

import lotto.view.ExceptionMessage;

public class LottoAmountValidator {
    public final int amount;
    private static final int LOTTO_MIN_AMOUNT = 1000;

    public LottoAmountValidator(String amount) {
        this.amount = validateNumber(amount);
        validate();
    }

    public void validate() {
        validateNatural(amount);
        validateDivisible(amount);
    }

    private int validateNumber(String amount) throws IllegalArgumentException {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            ExceptionMessage.numberException();
            throw new IllegalArgumentException();
        }
    }

    private void validateNatural(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NATURAL_NUMBER_ERROR);
        }
    }

    private void validateDivisible(int amount) {
        if (amount % LOTTO_MIN_AMOUNT != 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_DIVISIBLE_NUMBER_ERROR);
        }
    }
}
