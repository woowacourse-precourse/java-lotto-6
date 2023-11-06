package lotto.domain.ticket;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.result.LottoWinResult;
import lotto.domain.result.WinResult;

public class LottoTicket implements Ticket{
        private final List<Lotto> lottoEntry;

        public LottoTicket(List<Lotto> lottoEntry) {
                this.lottoEntry = lottoEntry;
        }

        @Override
        public WinResult checkResult(Lotto answer, int magicNumber) {
                return new LottoWinResult(lottoEntry, answer, magicNumber);
        }

        @Override
        public long getNumOfLottoEntry(){
                return lottoEntry.size();
        }
}
