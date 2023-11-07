package lotto.domain;

import static lotto.configuration.IntegerConstants.COST_OF_LOTTO;

import lotto.util.IntegerUtil;
import lotto.util.StringUtil;
import lotto.validation.IntegerValidator;

public class ThousandUnitMoney {

    private final int amount;

    private ThousandUnitMoney(int amount) {
        IntegerValidator.validateMultipleOf(amount,COST_OF_LOTTO.getValue());
        this.amount = amount;
    }

    public static ThousandUnitMoney create(int input) {
        return new ThousandUnitMoney(input);
    }

    public static ThousandUnitMoney create(String input) {
        return new ThousandUnitMoney(IntegerUtil.trimAndParseInt(input));
    }

    public boolean isSameAmount(int amount) {
        return this.amount == amount;
    }

    public int plus(ThousandUnitMoney money) {
        return this.amount + money.amount;
    }

    public boolean isSameAmount(int amount) {
        return this.amount == amount;
    }

    @Override
    public String toString() {
        return StringUtil.formatByThousandSeparator(amount);
    }
}
