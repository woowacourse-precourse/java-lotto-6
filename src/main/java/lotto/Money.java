package lotto;

public class Money {

    private static final int TICKET_PRICE = 1000;

    private final int money;

    public Money(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상이어야 합니다.");
        }
        this.money = money;
    }

    public int geBuyTicket() {
        return money / TICKET_PRICE;
    }

    public int getMoney() {
        return money;
    }
}
