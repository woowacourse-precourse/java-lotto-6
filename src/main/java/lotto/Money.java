package lotto;

public class Money {

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int getLottoCount() {
        return money / 1000;
    }
}
