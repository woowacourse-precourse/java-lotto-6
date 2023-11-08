package lotto.domain;

public enum Payment {
    MONEY_UNIT(1000);
    private final int money;

    private Payment(int money) {
        this.money = money;
    }

    public int getPrize() {
        return money;
    }
}
