package lotto.domain;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateMultiple(money);
    }

    private void validateMultiple(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 한장이 1000원이므로 구매금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public int calculatePurchasedLotto() {
        return money / 1000;
    }

    @Override
    public String toString() {
        return String.valueOf(calculatePurchasedLotto());
    }
}
