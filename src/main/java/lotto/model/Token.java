package lotto.model;

public class Token {

    private static final int UNIT_AMOUNT = 1000;
    private static final int ZERO = 0;
    private static final String WRONG_AMOUNT = "[ERROR] 구입금액은 1,000원 단위만 가능합니다.";
    private static final String ALERT_MIN_AMOUNT = "[ERROR] 최소 구입금액은 1,000원입니다.";
    private final int count;

    public Token(int amount) {
        validate(amount);
        this.count = amount / UNIT_AMOUNT;
    }

    private void validate(int amount) {
        if (isWrongUnit(amount)) {
            throw new IllegalArgumentException(WRONG_AMOUNT);
        }

        if (isNotMinAmount(amount)) {
            throw new IllegalArgumentException(ALERT_MIN_AMOUNT);
        }
    }

    private boolean isNotMinAmount(int amount) {
        return amount < UNIT_AMOUNT;
    }

    private boolean isWrongUnit(int amount) {
        return amount % UNIT_AMOUNT != ZERO;
    }
}
