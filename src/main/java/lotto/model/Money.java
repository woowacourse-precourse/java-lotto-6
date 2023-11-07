package lotto.model;

import static lotto.model.Input.POSITIVE_NUMBER_PATTERN;

public class Money {

    public static final int CURRENT_UNIT = 1000;
    public static final String INPUT_POSITIVE_ERROR = "[ERROR] 양의 정수만 입력해주세요.";
    public static final String MONEY_UNIT_ERROR = "[ERROR] 금액은 " + CURRENT_UNIT + "으로 나누어 떨어져야 합니다.";

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
            throw new IllegalArgumentException(INPUT_POSITIVE_ERROR);
        }
    }

    private void isModEqualZero() {
        if (money % CURRENT_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR);
        }
    }
}
