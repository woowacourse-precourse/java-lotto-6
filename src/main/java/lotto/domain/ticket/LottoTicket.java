package lotto.domain.ticket;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.result.LottoWinResult;
import lotto.domain.result.WinResult;

/**
 * 로또를 포함하는 Ticket 역할의 개념 객체를 나타내는 클래스입니다.
 */
public class LottoTicket implements Ticket {
        private final List<Lotto> lottoEntry;

        public LottoTicket(List<Lotto> lottoEntry) {
                this.lottoEntry = lottoEntry;
        }

        /**
         * 전달받은 당첨 로또 번호와 보너스 숫자를 바탕으로, 로또의 결과를 생성 후 반환합니다.
         *
         * @param answer 당첨 로또
         * @param magicNumber 보너스 숫자
         * @return 로또 결과
         */
        @Override
        public WinResult checkResult(Lotto answer, int magicNumber) {
                return new LottoWinResult(lottoEntry, answer, magicNumber);
        }

        @Override
        public long getNumOfLottoEntry() {
                return lottoEntry.size();
        }
}
