package lotto.domain;

public class Money {
    private static final long TICKET_PRICE = 1000L;
    private static final String MINIMUM_BUDGET_ERROR_MESSAGE = "1000원 이상으로 금액을 입력해야합니다.";
    private static final String NOT_DIVISIBLE_ERROR_MESSAGE = "구입금액은 1000원 단위이어야 합니다.";

    private final long money;

    public Money(long money) {
        validate(money);
        this.money = money;
    }

    private void validate(long money) {
        validateMinimumBudget(money);
        validateDivisible(money);
    }

    private void validateMinimumBudget(long money) {
        if (money < TICKET_PRICE) {
            throw new IllegalArgumentException(MINIMUM_BUDGET_ERROR_MESSAGE);
        }
    }

    private void validateDivisible(long money) {
        if (money % TICKET_PRICE != 0L) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_ERROR_MESSAGE);
        }
    }

    public long getMoney() {
        return money;
    }

    public long getTicket() {
        return money / TICKET_PRICE;
    }
}
