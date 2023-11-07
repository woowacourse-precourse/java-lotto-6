package lotto.domain;

public class Money {
    private static final int NO_REMAINDER = 0;
    private static final int MINIMUM_VALID_MONEY = 0;
    private static final int UNIT_OF_MONEY = 1000;
    private static final String INVALID_TYPE_ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자여야 합니다.";
    private static final String INVALID_UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";

    private final int money;

    public Money(String money) {
        validate(money);
        this.money = Integer.parseInt(money);
    }

    private void validate(String money) {
        if (isInvalidType(money)) {
            throw new IllegalArgumentException(INVALID_TYPE_ERROR_MESSAGE);
        }
        if (isInvalidUnit(money)) {
            throw new IllegalArgumentException(INVALID_UNIT_ERROR_MESSAGE);
        }
    }

    private boolean isInvalidType(String target) {
        try {
            Integer.parseInt(target);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private boolean isInvalidUnit(String target) {
        int money = Integer.parseInt(target);
        if (money > MINIMUM_VALID_MONEY && money % UNIT_OF_MONEY == NO_REMAINDER) {
            return false;
        }
        return true;
    }

    public int calculateLottoPurchaseSize() {
        return money / UNIT_OF_MONEY;
    }

    public double calculateProfitRate(Long reward) {
        return (reward / (float) money) * 100;
    }
}
