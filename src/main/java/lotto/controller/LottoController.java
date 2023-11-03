package lotto.controller;

import lotto.domain.Lottos;
import lotto.service.GetLottoTicket;
import lotto.service.InputLottoAmount;

public class LottoController {
    public void startLotto() {
        int lottoTicketCount = setAmount();
        Lottos lottos = getLottos(lottoTicketCount);
    }

    public int setAmount() {
        int lottoTicketCount = InputLottoAmount.setInputLottoAmount();
        return lottoTicketCount;
    }

    public Lottos getLottos(int lottoTicketCount) {
        Lottos lottos = GetLottoTicket.setLottoTickets(lottoTicketCount);
        return lottos;
    }
}
