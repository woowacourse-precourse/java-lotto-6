package lotto.model;

import lotto.ErrorMessage;

public class Amount {

    private static final int STANDARD_AMOUNT = 1000;
    private final int amount;

    public Amount(String amount) {
        validate(amount);
        this.amount = parseAmountToInt(amount);
    }

    private int parseAmountToInt(String amount) {
        return Integer.parseInt(amount);
    }

    private void validate(String amount) {
        try {
            int parsedAmount = parseAmountToInt(amount);

            if (parsedAmount < STANDARD_AMOUNT) {
                throw new IllegalArgumentException(ErrorMessage.MINIMUM_AMOUNT.getMessage());
            }

            if (parsedAmount % STANDARD_AMOUNT != 0) {
                throw new IllegalArgumentException(ErrorMessage.AMOUNT_UNIT.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_AMOUNT.getMessage());
        }
    }

    public int getAmount() {
        return this.amount;
    }
}
