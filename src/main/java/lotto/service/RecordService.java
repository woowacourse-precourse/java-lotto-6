package lotto.service;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.Result;

public class CalculateService {

    public void calculateResult(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            Result[] values = Result.values();
            for (Result value : values) {
                if(lottoTicket.getSameCount()==value.getSameCount()){

                }
            }
        }
    }
}
