package lotto.controller;

import lotto.service.LottoGameService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final LottoGameService lottoGameService;
    private final OutputView outputView;

    public LottoGameController(InputView inputView, OutputView outputView, LottoGameService lottoGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGameService = lottoGameService;
    }

    public void start() {
        buyLotto();
    }

    private void buyLotto() {
        int paymentAmount = Integer.parseInt(inputView.enterPaymentAmount());
        outputView.generateBlank();
//        lottoGameService.buyLotto(paymentAmount);
//        lottoGameService.checkPurchasedLotto();
        outputView.showPurchasedLotto(
                lottoGameService.buyLotto(paymentAmount),
                lottoGameService.checkPurchasedLotto()
        );
    }
}
