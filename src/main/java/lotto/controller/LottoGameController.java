package lotto.controller;

import lotto.model.LottoBuyer;
import lotto.model.LottoSeller;
import lotto.service.LottoGameService;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoGameController {
    private final ConsoleInputView inputView;
    private final ConsoleOutputView outputView;
    private final LottoGameService lottoGameService;

    public LottoGameController(
            ConsoleInputView inputView,
            ConsoleOutputView outputView,
            LottoGameService lottoGameService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGameService = lottoGameService;
    }

    public void run() {
        final LottoSeller seller = new LottoSeller();
        final LottoBuyer buyer = new LottoBuyer();
        int countOfLotto = lottoGameService.calculateLottoCountOnBuy(buyer);
    }
}
