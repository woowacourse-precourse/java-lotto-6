package lotto.domain.ticket;

import lotto.domain.lotto.Lotto;
import lotto.domain.result.WinResult;

/**
 * 로또를 포함한 Ticket 역할의 책임을 정의한 인터페이스입니다.
 */
public interface Ticket {
        /**
         * 주어진 당첨 로또 번호를 통해서 로또의 결과를 반환합니다.
         *
         * @param answer 당첨 로또
         * @param magicNumber 보너스 숫자
         * @return 로또 결과
         */
        WinResult checkResult(Lotto answer, int magicNumber);

        /**
         * 티켓에 포함된 로또의 수를 반환합니다.
         * @return 로또의 수
         */
        long getNumOfLottoEntry();
}
