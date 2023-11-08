package lotto.domain.seller;

import lotto.domain.money.Money;
import lotto.domain.ticket.Ticket;

/**
 * 로또 티켓을 판매하는 Seller 역할의 책임을 정의한 인터페이스입니다.
 */
public interface Seller {
        /**
         * Seller 는 전달받은 금액에 맞게 티켓을 판매할 수 있다.
         * @param payment 구입 금액
         * @return 티켓
         */
        Ticket sellTo(Money payment);
}
