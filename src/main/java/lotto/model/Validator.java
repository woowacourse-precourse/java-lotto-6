package lotto.model;

import lotto.constants.Constants;
import lotto.constants.Errors;
import lotto.constants.Message;

public class Validator {
    public void validateCost(String cost) {
        if (notNumeric(cost)) {
            throw new IllegalArgumentException(Errors.COST_NUMERIC);
        }
        if (notThousands(cost)) {
            throw new IllegalArgumentException(Errors.COST_THOUSANDS);
        }
    }

    private boolean notThousands(String cost) {
        return (Long.parseLong(cost) % Constants.LOTTO_PRICE != 0);
    }

    public void validateAnswer(String number) {
        if (notNumeric(number)) {
            throw new IllegalArgumentException(Errors.ANSWER_NUMERIC);
        }
        if (outOfRange(number)) {
            throw new IllegalArgumentException(Errors.ANSWER_RANGE);
        }
    }

    public void validateBonus(String number) {
        if (notNumeric(number)) {
            throw new IllegalArgumentException(Errors.BONUS_NUMERIC);
        }
        if (outOfRange(number)) {
            throw new IllegalArgumentException(Errors.BONUS_RANGE);
        }
    }

    private boolean notNumeric(String number) {
        return !number.matches(Message.REGULAR_NUMBER);
    }

    private boolean outOfRange(String number) {
        int num = Integer.parseInt(number);

        return (num < Constants.START || Constants.END < num);
    }
}
