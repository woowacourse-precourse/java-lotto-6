package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

import java.util.List;

public class LottoMachine {
    public static List<Lotto> createLottoTicket(int ticketCount) {
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.createLotto(ticketCount);
        return lottoTicket.getLottoTicket();
    }
}
