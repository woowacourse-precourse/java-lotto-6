package lotto.service;

import lotto.domain.Amount;
import lotto.domain.Ticket;

public class LottoService {

    private static final int THOUSAND = 1000;

    public Ticket calculateTicketFromAmonut(final Amount amount) {
        return new Ticket(amount.divideByThousand());
    }
}
