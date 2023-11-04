package lotto.io;

import lotto.constant.ProcessMessage;
import lotto.domain.Ticket;

public class OutputFommatter {

    public String toNumberOfTicket(final Ticket ticket) {
        return String.format(ProcessMessage.NUMBER_OF_LOTTO_TICKET.toValue(), ticket.tovalue());
    }
}
