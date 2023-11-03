package lotto.model;

public final class UserMoney {
    private static final String NEGATIVE_MONEY_EXCEPTION = "사용자가 투입한 금액에서 음수는 입력할 수 없습니다.";
    private static final String ZERO_MONEY_EXCEPTION = "사용자가 투입한 금액에서 0원은 입력할 수 없습니다.";
    private static final String ONE_HUNDRED_MILLION_MONEY_EXCEPTION = "사용자가 투입한 금액에서 1억원 이하로 입력해주세요.";
    private static final int ZERO_MONEY = 0;
    private static final int ONE_HUNDRED_MILLION_MONEY = 100_000_000;

    private final int money;

    private UserMoney(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        ensurePositive(money);
        ensureNotZero(money);
        ensureBelowMaximumLimit(money);
    }

    private void ensurePositive(int money) {
        if (money < ZERO_MONEY) {
            throw new IllegalArgumentException(NEGATIVE_MONEY_EXCEPTION);
        }
    }

    private void ensureNotZero(int money) {
        if (money == ZERO_MONEY) {
            throw new IllegalArgumentException(ZERO_MONEY_EXCEPTION);
        }
    }

    private void ensureBelowMaximumLimit(int money) {
        if (money > ONE_HUNDRED_MILLION_MONEY) {
            throw new IllegalArgumentException(ONE_HUNDRED_MILLION_MONEY_EXCEPTION);
        }
    }

    public static UserMoney from(int money) {
        return new UserMoney(money);
    }
}
