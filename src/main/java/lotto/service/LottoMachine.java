package lotto.service;

import lotto.domain.LottoTicket;

public class LottoMachine {
    public static LottoTicket createLottoTicket(int ticketCount) {
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.createLotto(ticketCount);
        return lottoTicket;
    }
}
