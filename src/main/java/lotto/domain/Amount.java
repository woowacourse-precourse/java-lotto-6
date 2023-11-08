package lotto.domain;

import lotto.enumeration.Constants;
import lotto.enumeration.ExceptionType;

public class Amount {
    final private int amount;

    public Amount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount > Constants.AMOUNT_LIMIT.getConstant() ||
                amount < Constants.UNITS_OF_AMOUNT.getConstant()) {
            throw new IllegalArgumentException(ExceptionType.EXCEED_AMOUNT_LIMIT.getMessage());
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionType.AMOUNT_NOT_MULTIPLE_1000.getMessage());
        }
    }

    public int getTicketCount() {
        return amount / Constants.UNITS_OF_AMOUNT.getConstant();
    }

    public int getAmount() {
        return amount;
    }
}
