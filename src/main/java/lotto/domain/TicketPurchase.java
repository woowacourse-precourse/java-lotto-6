package lotto.domain;


import static lotto.constant.TicketPrice.TICKET_PRICE;

public class TicketPurchase {

    private final int payment;
    public int ticketCount;

    public TicketPurchase(int payment) {
        this.payment = payment;
        calculateTicketCount();
    }

    private void calculateTicketCount() {
        this.ticketCount = this.payment/ TICKET_PRICE.getValue();
    }

    public int getTicket() {
        return ticketCount;
    }

}
