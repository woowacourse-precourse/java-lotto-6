package lotto.domain.generator;

import lotto.domain.ticket.Ticket;

public interface TicketGenerator {
        Ticket generateTicket(long quantity);
}
