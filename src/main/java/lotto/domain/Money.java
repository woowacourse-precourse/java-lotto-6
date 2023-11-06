package lotto.domain;

import static lotto.messages.ErrorMessages.INVALID_MULTIPLE_OF_1000_MESSAGE;

import lotto.util.ExceptionUtil;
import lotto.util.IntegerUtil;
import lotto.validation.IntegerValidator;

public class Money {

    int amount;

    private Money(int amount) {
        validateMultipleOf1000(amount);
        this.amount = amount;
    }

    public static Money create(int input) {
        return new Money(input);
    }

    public static Money create(String input) {
        return new Money(processStringToInt(input));
    }


}
