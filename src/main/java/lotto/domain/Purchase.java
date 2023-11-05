package lotto.domain;

import lotto.domain.vo.TicketCount;
import lotto.domain.vo.TotalAmount;

public class Purchase {
    private TotalAmount totalAmount;
    private TicketCount ticketCount;

    private Purchase(TotalAmount totalAmount, TicketCount ticketCount) {
        this.totalAmount = totalAmount;
        this.ticketCount = ticketCount;
    }

}
