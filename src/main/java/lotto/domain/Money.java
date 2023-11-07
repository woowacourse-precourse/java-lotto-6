package lotto.domain;

public class Money {
    private static final int MONEY_UNIT = 1000;
    private final int money;

    public Money(int money) {
        validateMoneyRange(money);
        validateMoneyUnit(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validateMoneyRange(int money) {
        if (money < MONEY_UNIT) {
            throw new IllegalArgumentException("[ERROR] 1000원 이상 입력해 주세요.");
        }
    }

    private void validateMoneyUnit(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 돈을 입력 해야 합니다.");
        }
    }
}
