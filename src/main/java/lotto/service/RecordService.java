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
            addResultCount(lottoTicket, value);
        }
    }

    private void addResultCount(LottoTicket lottoTicket, Result value) {
        if (isSameCountFive(value)) {
            checkIsSecond(lottoTicket, value);
            return;
        }
        if (isNoBonus(lottoTicket)) {
            value.addCount();
        }
    }

    private boolean isNoBonus(LottoTicket lottoTicket) {
        return !lottoTicket.isBonus();
    }

    private boolean isSameCountFive(Result value) {
        return value.getSameCount() == SAME_COUNT_FIVE.getNumber();
    }

    private void checkIsSecond(LottoTicket lottoTicket, Result value) {
        if (lottoTicket.isBonus() && value.isBonus()) {
            Result.SECOND.addCount();
        }
    }

}
