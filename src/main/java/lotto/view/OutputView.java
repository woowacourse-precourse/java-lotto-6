package lotto.view;

import static lotto.util.content.DisplayMessage.GET_PURCHASE_AMOUNT;
import static lotto.util.content.DisplayMessage.NEXT_LINE;

import java.util.List;
import lotto.domain.Ticket;

public class OutputView {

    public static void displayTicket(List<Ticket> tickets) {
        System.out.println(NEXT_LINE.getContent() +
                tickets.size() + GET_PURCHASE_AMOUNT.getContent());
        for (Ticket ticket : tickets) {
            System.out.println(ticket.toString());
        }
    }

}
