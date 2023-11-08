package lotto.type;

public enum Reward {

    FIVE(5000),
    FOUR(50000),
    THREE(1500000),
    TWO(30000000),
    ONE(2000000000);
    private final int money;

    Reward(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

}
