package lotto.domain;

public class Money {

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 돈은 음수가 될 수 없습니다. 다시 입력해 주세요.");
        }
    }

    public int getMoney() {
        return money;
    }
}
