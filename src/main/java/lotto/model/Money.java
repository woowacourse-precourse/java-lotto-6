package lotto.model;

import static lotto.model.ErrorMessage.INPUT_POSITIVE_ERROR;
import static lotto.model.ErrorMessage.MONEY_UNIT_ERROR;
import static lotto.model.Input.POSITIVE_NUMBER_PATTERN;

public class Money {

    public static final int CURRENT_UNIT = 1000;

    private final int money;

    public Money(String input) {
        isPositiveNumber(input);
        money = Integer.parseInt(input);
        isModEqualZero();
    }

    public int getMoney() {
        return money;
    }

    public int getPurchaseLottoCount() {
        return money / CURRENT_UNIT;
    }

    private void isPositiveNumber(String target) {
        if (!target.matches(POSITIVE_NUMBER_PATTERN)) {
            throw new IllegalArgumentException(INPUT_POSITIVE_ERROR.getMessage());
        }
    }

    private void isModEqualZero() {
        if (money % CURRENT_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR.getMessage());
        }
    }
}
