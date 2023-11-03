package lotto.model;

public class Money {
    private static final int THOUSAND = 1_000;

    private final int money;

    public Money(int money) {
        validateDivideMoney(money);
        this.money = money;
    }

    private void validateDivideMoney(int money) {
        if (money % THOUSAND != 0) {
            throw new IllegalArgumentException("1,000 단위만 입력할 수 있습니다.");
        }
    }
}
