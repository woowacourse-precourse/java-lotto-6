package lotto.domain;

public class Money {
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int getNumberTickets() {
        return money / 1000;
    }
}
