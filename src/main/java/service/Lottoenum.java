package service;

public enum Lottoenum {
    LOTTOPRICE(1000),
    FIFTH(5000),
    FOURTH(50000),
    THIRD(1500000),
    SECOND(30000000),
    FIRST(2000000000);
    private int money;

    Lottoenum(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
