package lotto.model;

public enum Winning {

    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FORTH(50000),
    FIFTH(5000);


    private final int money;

    Winning(int money) {
        this.money = money;
    }
}
