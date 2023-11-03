package lotto.domain;


import static lotto.constant.TicketPrice.TICKET_PRICE;

public class Ticket {

    private final int ticketPrice = TICKET_PRICE.getValue();
    private final int money;
    public int amount;

    public Ticket(int money) {
        this.money = money;
        calculateTicketAmount();
    }

    private void calculateTicketAmount() {
        amount = money / ticketPrice;
    }

    public int getTicket() {
        return amount;
    }

}
