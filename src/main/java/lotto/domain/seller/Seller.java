package lotto.domain.seller;

import lotto.domain.money.Money;
import lotto.domain.ticket.Ticket;

/**
 * Seller 의 핵심 로직을 정의한 인터페이스입니다.
 */
public interface Seller {
        /**
         * Seller 는 티켓을 판매할 수 있다.
         * @param payment 구입 금액
         * @return 티켓
         */
        Ticket sellTo(Money payment);
}
