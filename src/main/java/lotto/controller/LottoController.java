package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.service.GetLottoTicket;
import lotto.service.InputLottoAmount;
import lotto.service.InputWinningLotto;
import lotto.service.LottoRogic;

public class LottoController {
    public void startLotto() {
        int lottoTicketCount = setAmount();
        Lottos lottos = getLottos(lottoTicketCount);
        WinningLotto lotto = setWinningLotto();
        LottoRogic.matchWinningLotto(lottos, lotto);
    }

    public int setAmount() {
        int lottoTicketCount = InputLottoAmount.setInputLottoAmount();
        return lottoTicketCount;
    }

    public Lottos getLottos(int lottoTicketCount) {
        Lottos lottos = GetLottoTicket.setLottoTickets(lottoTicketCount);
        return lottos;
    }

    public WinningLotto setWinningLotto() {
        WinningLotto winningLotto = InputWinningLotto.setInputWinningLotto();
        return winningLotto;
    }
}
