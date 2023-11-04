package lotto.io;

import lotto.constant.ProcessMessage;
import lotto.domain.Amount;

public class OutputFommatter {

    private static final int THOUSAND = 1000;

    public String toNumberOfTicket(final Amount amount) {
        Integer ticketAmount = divideByThousand(amount);
        return String.format(ProcessMessage.NUMBER_OF_LOTTO_TICKET.toValue(), ticketAmount);
    }

    private Integer divideByThousand(final Amount amount) {
        return amount.toValue() / THOUSAND;
    }
}
