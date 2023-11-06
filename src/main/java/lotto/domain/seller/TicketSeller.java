package lotto.domain.seller;

import java.math.RoundingMode;
import lotto.domain.generator.TicketGenerator;
import lotto.domain.money.Money;
import lotto.domain.ticket.Ticket;

public class TicketSeller implements Seller {
        private final TicketGenerator generator;

        public TicketSeller(TicketGenerator generator) {
                this.generator = generator;
        }

        @Override
        public Ticket sellTo(Money payment) {
                return generator.generateTicket(calculateQuantity(payment));
        }

        private long calculateQuantity(Money payment) {
                return payment.getAmount()
                        .divide(TicketPrice.COMMON.getPrice(), 0, RoundingMode.DOWN)
                        .longValue();
        }
}
