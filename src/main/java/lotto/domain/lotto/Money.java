package lotto.domain.lotto;

public class Money {
    private static final int LOTTO_COST = 1_000;
    private final int money;

    public Money(int money) {
        this.money = money;
        validateMoneyDividedByThousand();
    }

    private void validateMoneyDividedByThousand() {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException("돈은 1000원 단위로 나누어 져야 함");
        }
    }

    public int getNumberOfTheLotto() {
        return money / LOTTO_COST;
    }

    public int getMoney() {
        return money;
    }
}
