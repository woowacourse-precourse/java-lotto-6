package lotto.domain;

import static lotto.constant.ErrorMessage.*;

public class Money {
    private final int spendAmount;

    public Money(String spendAmount) {
        validate(spendAmount);
        this.spendAmount = Integer.parseInt(spendAmount);
    }

    private void validate(String spendAmount) {
        validateIsDigit(spendAmount);
        validateDividedByThousand(spendAmount);
        validateRangeOfSpendAmount(spendAmount);
    }

    private void validateIsDigit(String spendAmount) {
        try{
            Integer.parseInt(spendAmount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INPUT_NUMBER_INCLUDE_STRING_WARNING);
        }
    }

    private void validateRangeOfSpendAmount(String spendAmount) {
        int spent = Integer.parseInt(spendAmount);
        if(spent < 1000 || spent > 100000) {
            throw new IllegalArgumentException(SPENT_AMOUNT_RANGE_WARNING);
        }
    }

    private void validateDividedByThousand(String spendAmount) {
        int spent = Integer.parseInt(spendAmount);
        if(spent % 1000 != 0) {
            throw new IllegalArgumentException(SPENT_AMOUNT_UNIT_WARNING);
        }
    }
}
