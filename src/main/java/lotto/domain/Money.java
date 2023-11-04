package lotto.domain;

public class Money {
    private int money;
    public Money(int money) {
        if(!validate(money)) throw new IllegalArgumentException("[Error]: 단위는 1000단위로 떨어져야 합니다.");
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private boolean validate(int money) {
        return money % ValidationConstants.STANDARD_UNIT == 0;
    }
}
