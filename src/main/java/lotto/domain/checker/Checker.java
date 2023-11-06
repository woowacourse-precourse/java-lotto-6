package lotto.domain.checker;

import lotto.domain.result.WinResult;
import lotto.domain.ticket.Ticket;

/**
 * Checker 의 핵심 로직을 정의한 인터페이스 입니다.
 */
public interface Checker {
        /**
         * Checker 는 티켓의 결과를 검사할 수 있습니다.
         * @param ticket 고객이 구매한 로또 티켓
         * @return 로또 결과
         */
        WinResult checkTicket(Ticket ticket);
}
