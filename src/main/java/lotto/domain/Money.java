package lotto.domain;

public class Money {
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 잘못입력했습니다.");
        }
    }

    public int getMoney() {
        return money;
    }

    public int getLottoQuantity() {
        return money / 1000;
    }
}
