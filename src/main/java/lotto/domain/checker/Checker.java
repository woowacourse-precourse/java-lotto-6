package lotto.domain.checker;

import lotto.domain.result.WinResult;
import lotto.domain.ticket.Ticket;

public interface Checker {
        WinResult checkTicket(Ticket ticket);
}
