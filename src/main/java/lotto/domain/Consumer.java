package lotto.domain;

public class Consumer {

    private final int amount;
    private final int tickets;

    public Consumer(int amount, int tickets) {
        this.amount = amount;
        this.tickets = tickets;
    }

    public int getAmount() {
        return amount;
    }

    public int getTicketCount() {
        return tickets;
    }
}
