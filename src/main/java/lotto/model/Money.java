package lotto.model;

public class Money {
    private static final int THOUSAND = 1_000;
    private static final int ZERO = 0;

    private final int money;

    public Money(int money) {
        validateZeroMoney(money);
        validateDivideMoney(money);
        this.money = money;
    }

    private void validateZeroMoney(int money) {
        if (money == ZERO) {
            throw new IllegalArgumentException("0원은 입력할 수 없습니다.");
        }
    }

    private void validateDivideMoney(int money) {
        if (money % THOUSAND != ZERO) {
            throw new IllegalArgumentException("1,000원 단위만 입력할 수 있습니다.");
        }
    }
}
