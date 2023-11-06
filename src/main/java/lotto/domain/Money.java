package lotto.domain;

public class Money {
    private static final int THOUSAND = 1000;
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int getTicket() {
        return money / THOUSAND;
    }
}
