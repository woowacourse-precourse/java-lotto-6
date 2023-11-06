package lotto.domain.ticket;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.result.LottoWinResult;
import lotto.domain.result.WinResult;

/**
 * Ticket 을 구현한 개념 객체를 나타내는 클래스입니다.
 */
public class LottoTicket implements Ticket {
        /**
         * 티켓에 포함될 로또 리스트
         */
        private final List<Lotto> lottoEntry;

        /**
         * LottoTicket 의 생성자 함수로 로또 리스트를 주입 받습니다.
         * @param lottoEntry 로또 리스트
         */
        public LottoTicket(List<Lotto> lottoEntry) {
                this.lottoEntry = lottoEntry;
        }

        /**
         * 로또의 결과를 생성 후 반환합니다.
         *
         * @param answer 당첨 로또
         * @param magicNumber 보너스 숫자
         * @return 로또 결과
         */
        @Override
        public WinResult checkResult(Lotto answer, int magicNumber) {
                return new LottoWinResult(lottoEntry, answer, magicNumber);
        }

        /**
         * 티켓에 포함된 로또의 수를 반환한다.
         *
         * @return 로또의 수
         */
        @Override
        public long getNumOfLottoEntry() {
                return lottoEntry.size();
        }
}
