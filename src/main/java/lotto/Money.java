package lotto;

public class Money {

    private static final int TICKET_PRICE = 1000;

    private final int money;

    public Money(int money) {}

    public int geBuyTicket() {
        return money / TICKET_PRICE;
    }
}
