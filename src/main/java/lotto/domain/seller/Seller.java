package lotto.domain.seller;

import lotto.domain.money.Money;
import lotto.domain.ticket.Ticket;

public interface Seller {
        Ticket sellTo(Money payment);
}
