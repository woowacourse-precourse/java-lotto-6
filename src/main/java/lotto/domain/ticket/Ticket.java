package lotto.domain.ticket;

import lotto.domain.lotto.Lotto;
import lotto.domain.result.WinResult;

public interface Ticket {
        WinResult checkResult(Lotto answer, int magicNumber);
        long getNumOfLottoEntry();
}
