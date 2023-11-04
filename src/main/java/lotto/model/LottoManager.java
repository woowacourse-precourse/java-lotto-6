package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Tickets;

public class LottoManager {
    private Tickets tickets = new Tickets();
    private int TICKET_PRICE = 1000;

    public void buyTickets(int money) {
        int amount = calculateTicketAmount(money);
        tickets.generateTickets(amount);
    }

    public List<String> getTickets() {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < tickets.getTicketsCount(); i++) {
            String ticket = tickets.getTicketOfIndex(i);
            list.add(ticket);
        }

        return list;
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
