package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.service.GetLottoTicket;
import lotto.service.InputLotto;
import lotto.service.InputLottoAmount;

public class LottoController {
    public void startLotto() {
        int lottoTicketCount = setAmount();
        Lottos lottos = getLottos(lottoTicketCount);
        Lotto lotto = setLotto();
    }

    public int setAmount() {
        int lottoTicketCount = InputLottoAmount.setInputLottoAmount();
        return lottoTicketCount;
    }

    public Lottos getLottos(int lottoTicketCount) {
        Lottos lottos = GetLottoTicket.setLottoTickets(lottoTicketCount);
        return lottos;
    }

    public Lotto setLotto() {
        Lotto lotto = InputLotto.setInputLotto();
        return lotto;
    }
}
