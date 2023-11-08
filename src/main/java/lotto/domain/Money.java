package lotto.domain;

public class Money {

    private final long money;

    public Money(long money) {
        validate(money);
        this.money = money;
    }

    public int getCount() {
        return (int)money/1000;
    }

    private void validate(long money) {
        if(0 != money%1000)
            throw new IllegalArgumentException();
    }


}
