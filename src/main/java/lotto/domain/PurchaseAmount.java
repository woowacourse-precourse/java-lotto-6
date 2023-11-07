package lotto.domain;

public class PurchaseAmount {

    private static final int LIMIT_MONEY = 0;

    private final int money;

    public PurchaseAmount(int money) {
        validateMoneyRange(money);
        this.money = money;
    }

    public int changeBy(int amount) {
        return money/amount;
    }

    private void validateMoneyRange(int money) {
        if(money < LIMIT_MONEY) {
            throw new IllegalArgumentException("돈은 음수이면 안됩니다");
        }
    }

    public boolean divisible(int amount) {
        if(money % amount == 0) {
            return true;
        }
        return false;
    }
}
