package lotto.domain;

import lotto.util.Constant;

public class Money {
    private long money;

    public Money(String input) {
        this.money = validate(input);
    }

    private long validate(String input) {
        long money = validateNumeric(input);
        return validateUnit(money);
    }

    private long validateNumeric(String input) {
        boolean isNumeric = input.matches(Constant.NUMERIC_REGEX);
        if (!isNumeric) {
            throw new IllegalArgumentException();
        }
        return Long.parseLong(input);
    }

    private long validateUnit(long money) {
        if (money % Constant.MONEY_UNIT != 0 || money < Constant.MONEY_UNIT) {
            throw new IllegalArgumentException();
        }
        return money;
    }

    public int calculateGameCount() {
        return (int) (this.money / Constant.MONEY_UNIT);
    }

    public long getMoney() {
        return money;
    }
}
