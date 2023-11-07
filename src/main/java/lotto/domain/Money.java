package lotto.domain;

public class Money {
    private final long money;

    public Money(long money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(long money) {
        if (isLackMoney(money)) {
            throw new IllegalArgumentException("금액은 1,000원 이상 투입 되어야 합니다.");
        }

        if (isWrongMoney(money)) {
            throw new IllegalArgumentException("금액은 1,000원 단위로 투입 되어야 합니다.");
        }
    }

    private boolean isLackMoney(long money) {
        return money < 1000;
    }

    private boolean isWrongMoney(long money) {
        return money % 1000 != 0;
    }

    public int getPurchaseCount() {
        return (int) money / 1000;
    }

    public long getMoney() {
        return money;
    }
}
