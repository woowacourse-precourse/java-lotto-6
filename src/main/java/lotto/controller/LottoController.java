package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService =new LottoService();
    }

    public void runGame() {
        int purchaseAmount = inputView.inputPurchaseAmount();

        List<Lotto> lotteryTickets = lottoService.buyLotto(purchaseAmount);
        outputView.showLotteryTickets(lotteryTickets);

    }
}
