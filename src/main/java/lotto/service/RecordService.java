package lotto.service;

import static lotto.constant.NumberConstant.SAME_COUNT_FIVE;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.Result;

public class RecordService {

    public void recordResult(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            for (Result value : Result.values()) {
                recordProcess(lottoTicket, value);
            }
        }
    }

    private void recordProcess(LottoTicket lottoTicket, Result value) {
        if (lottoTicket.getSameCount() == value.getSameCount()) {
            addResultCount(lottoTicket, value);
        }
    }

    private void addResultCount(LottoTicket lottoTicket, Result value) {
        if (checkIsSecond(lottoTicket, value)) {
            Result.SECOND.addCount();
            return;
        }
        if (isNoBonus(lottoTicket, value))
            value.addCount();
    }

    private boolean isNoBonus(LottoTicket lottoTicket, Result value) {
        return !lottoTicket.isBonus() && !value.isBonus();
    }

    private boolean checkIsSecond(LottoTicket lottoTicket, Result value) {
        return lottoTicket.isBonus() && value.isBonus();
    }

}
