package lotto.service;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.Result;

public class RecordService {

    public void recordResult(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            for (Result value : Result.values()) {
                recordResult(lottoTicket, value);
            }
        }
    }

    private void recordResult(LottoTicket lottoTicket, Result value) {
        if (lottoTicket.getSameCount() == value.getSameCount()) {
            if (value.getSameCount() == 5) {
                checkIsSecond(lottoTicket, value);
                return;
            }
            if (!lottoTicket.isBonus()) {
                value.addCount();
            }
        }
    }

    private void checkIsSecond(LottoTicket lottoTicket, Result value) {
        if (lottoTicket.isBonus() && value.isBonus()) {
            Result.SECOND.addCount();
        }
    }

}
