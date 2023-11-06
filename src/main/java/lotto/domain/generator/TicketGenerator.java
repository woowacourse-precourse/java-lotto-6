package lotto.domain.generator;

import lotto.domain.ticket.Ticket;

/**
 * TicketGenerator 의 핵심 로직을 정의한 인터페이스입니다.
 */
public interface TicketGenerator {
        /**
         * 전달받은 quantity 만큼의 로또를 포함한 티켓을 발행합니다.
         *
         * @param quantity 로또 구매 수량
         * @return 티켓
         */
        Ticket generateTicket(long quantity);
}
