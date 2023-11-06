package lotto.service;

import static lotto.constant.NumberConstant.SAME_COUNT_FIVE;

import java.util.List;
import lotto.constant.NumberConstant;
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
            if (value.getSameCount() == SAME_COUNT_FIVE.getNumber()) {
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
