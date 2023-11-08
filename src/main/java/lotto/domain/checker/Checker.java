package lotto.domain.checker;

import lotto.domain.result.WinResult;
import lotto.domain.ticket.Ticket;

/**
 * 로또의 결과를 판단하는 Checker 역할의 책임을 정의한 인터페이스 입니다.
 */
public interface Checker {
        /**
         * Checker 는 요청받은 티켓의 결과를 검사하고, 결과인 WinResult 를 반환합니다.
         *
         * @param ticket 로또 티켓
         * @return 로또 결과
         */
        WinResult checkTicket(Ticket ticket);
}
