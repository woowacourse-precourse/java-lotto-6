package lotto;

import java.util.regex.Pattern;

public class Money {
    private static final int UNIT = 1_000;
    private final int amount;

    public Money(String amount) {
        validate(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validate(String amount) {
        if (isNumber(amount)) {
            throw new IllegalArgumentException("[Error] 구매 금액은 숫자만 가능합니다.");
        }
        if (isCorrectUnit(amount)) {
            throw new IllegalArgumentException("[Error] 구매 금액은 1,000단위로만 입력 가능합니다.");
        }
        if (isZero(amount)) {
            throw new IllegalArgumentException("[Error] 구매 금액은 0원 이상만 가능합니다.");
        }
    }

    private boolean isNumber(String amount) {
        return !Pattern.matches("^[0-9]*$", amount);
    }

    private boolean isCorrectUnit(String amount) {
        return Integer.parseInt(amount) % UNIT != 0;
    }

    private boolean isZero(String amount) {
        return Integer.parseInt(amount) == 0;
    }
}
