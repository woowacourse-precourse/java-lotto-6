package lotto.domain;

public class Money {

    public static final int UNIT = 1000;
    private final int money;

    public Money(int money) {
        validatePositive(money);
        validateUnit(money);
        this.money = money;
    }

    private void validatePositive(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnit(int money) {
        if (money % UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int count() {
        return money / UNIT;
    }

}
