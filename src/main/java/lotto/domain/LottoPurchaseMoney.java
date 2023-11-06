package lotto.domain;

public class LottoPurchaseMoney {
    private static final int MINIMUM_AMOUNT = 1000;
    private static final int UNIT_OF_MONEY = 1000;
    private int money;


    public LottoPurchaseMoney(int money) {
        validateAmount(money);
        validateUnit(money);
        this.money = money;
    }

    private void validateAmount(int money) {
        if (money < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 최소 1000원 이상을 입력해야 합니다.");
        }
    }

    private void validateUnit(int money) {
        if (money % UNIT_OF_MONEY != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해야 합니다.");
        }
    }

    public int getMoney() {
        return this.money;
    }

}
