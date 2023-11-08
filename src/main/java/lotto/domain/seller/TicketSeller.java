package lotto.domain.seller;

import java.math.RoundingMode;
import lotto.domain.generator.TicketGenerator;
import lotto.domain.money.Money;
import lotto.domain.ticket.Ticket;

/**
 * 로또 티켓을 판매할 수 있는 Seller 역할의 개념 객체를 나타내는 클래입니다.
 */
public class TicketSeller implements Seller {
        private final TicketGenerator ticketGenerator;

        public TicketSeller(TicketGenerator ticketGenerator) {
                this.ticketGenerator = ticketGenerator;
        }

        /**
         * 전달받은 금액에 맞게 티켓을 판매할 수 있다.
         * @param payment 구입 금액
         * @return 티켓
         */
        @Override
        public Ticket sellTo(Money payment) {
                return ticketGenerator.generateTicket(calculateQuantity(payment));
        }

        /**
         * 전달받은 구입 금액으로, 구입할 수 있는 로또의 수를 계산합니다.
         *
         * @param payment 구입 금액
         * @return 구매 가능 수
         */
        private long calculateQuantity(Money payment) {
                return payment.amount()
                        .divide(TicketPrice.COMMON.getPrice(), 0, RoundingMode.DOWN)
                        .longValue();
        }
}
