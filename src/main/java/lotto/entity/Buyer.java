package lotto.entity;

public class Buyer {
    private final int receivedAmount;
    private final Ticket ticket;

    public Buyer(int receivedAmount, Ticket ticket) {
        this.receivedAmount = receivedAmount;
        this.ticket = ticket;
    }

    public int getReceivedAmount() {
        return receivedAmount;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
