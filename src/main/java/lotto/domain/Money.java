package lotto.domain;

public class Money {
    private final int money;
    public Money(int money) throws IllegalArgumentException{
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validate(int money) throws IllegalArgumentException {
        if(money % ValidationConstants.STANDARD_UNIT != 0) {
            throw new IllegalArgumentException("[Error]: 단위는 1000단위로 떨어져야 합니다.");
        }
    }
}
