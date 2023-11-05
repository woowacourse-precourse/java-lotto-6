package lotto.service;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.Result;

public class RecordService {

    public void recordResult(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            for (Result value : Result.values())
                recordResult(lottoTicket, value);
        }
    }

    private void recordResult(LottoTicket lottoTicket, Result value) {
        if(value.getSameCount()==5){
            bonusCalculate(lottoTicket);
        }
        else if (lottoTicket.getSameCount() == value.getSameCount()) {
            value.addCount();
        }
    }

    private static void bonusCalculate(LottoTicket lottoTicket) {
        if(lottoTicket.isBonus()){
            Result.SECOND.addCount();
            return;
        }
        Result.THIRD.addCount();
    }
}
