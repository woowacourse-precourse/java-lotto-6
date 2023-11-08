package lotto.enums;

public enum Ticket {
    TICKET_PRICE(1_000);
    private final int ticketPrice;

    Ticket(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }
}
