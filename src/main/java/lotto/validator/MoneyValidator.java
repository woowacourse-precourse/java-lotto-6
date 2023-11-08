package lotto.validator;

import static lotto.constant.MessageConstants.MONEY_RANGE;
import static lotto.constant.NumberConstants.MIN_MONEY;

public class MoneyValidator {

    private final String moneyString;

    public MoneyValidator(String moneyString) {
        this.moneyString = moneyString;
    }

    public void validateAll() {
        validateRange();
    }

    private void validateRange() {
        long money = Long.parseLong(moneyString);
        if (isWrongRange(money) || isWrongMoneyUnit(money)) {
            throw new IllegalArgumentException(MONEY_RANGE);
        }
    }

    private boolean isWrongRange(long money) {
        return money < MIN_MONEY;
    }

    private boolean isWrongMoneyUnit(long money) {
        return money % MIN_MONEY > 0;
    }

}
