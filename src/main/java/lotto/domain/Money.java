package lotto.domain;

public class Money {

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int getCount() {
        return money/1000;
    }

    private void validate(int money) {
        if(0 != money%1000)
            throw new IllegalArgumentException();
    }


}
