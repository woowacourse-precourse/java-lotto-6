package lotto.model;

import lotto.domain.Tickets;

public class LottoManager {
    private Tickets tickets = new Tickets();
    private int TICKET_PRICE = 1000;

    public void buyTickets(int money) {
        int amount = calculateTicketAmount(money);
        tickets.generateTickets(amount);
    }


    private int calculateTicketAmount(int money) {
        int amount = money / TICKET_PRICE;

        return amount;
    }

    
    // testcode
    protected int getTicketsCount() {
        return tickets.getTicketsCount();
    }

}
