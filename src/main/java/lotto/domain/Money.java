package lotto.domain;

import static lotto.configuration.IntegerConstants.COST_OF_LOTTO;
import static lotto.messages.ErrorMessages.INVALID_MULTIPLE_OF_1000_MESSAGE;

import lotto.util.ExceptionUtil;
import lotto.util.IntegerUtil;
import lotto.util.StringUtil;
import lotto.validation.IntegerValidator;

public class Money {

    int amount;

    private Money(int amount) {
        IntegerValidator.validateMultipleOf(amount,COST_OF_LOTTO.getValue());
        this.amount = amount;
    }

    public static Money create(int input) {
        return new Money(input);
    }

    public static Money create(String input) {
        return new Money(IntegerUtil.trimAndParseInt(input));
    }

    public Money plus(Money money) {
        return new Money(this.amount + money.amount);
    }

    public boolean isSameAmount(int amount) {
        return this.amount == amount;
    }

    @Override
    public String toString() {
        return StringUtil.formatByThousandSeparator(amount);
    }
}
