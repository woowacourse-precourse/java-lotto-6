package lotto.controller;

import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public Lottos createLottoTicket() {
        return lottoService.generateLottoTicket();
    }

    public void showLottoPurchase(Lottos lottoTicket) {
        OutputView.printMessage(lottoTicket);
    }
}
