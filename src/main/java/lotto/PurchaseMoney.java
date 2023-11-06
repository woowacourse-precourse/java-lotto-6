package lotto;

public class PurchaseMoney {
    private static int LOTTO_TICKET_PRICE = 1000;

    private final int amount;

    public PurchaseMoney(int amount) {
        this.amount = amount;
    }

    public int getLottoTicketQuantity() {
        return amount / LOTTO_TICKET_PRICE;
    }
}
