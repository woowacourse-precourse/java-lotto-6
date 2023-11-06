package lotto.controller;

import lotto.service.LottoGameService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGameService lottoGameService;

    public LottoGameController(InputView inputView, OutputView outputView, LottoGameService lottoGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGameService = lottoGameService;
    }

    public void start() {
        buyLotto();
        generateWinningNumber();
    }

    private void buyLotto() {
        int paymentAmount = Integer.parseInt(inputView.enterPaymentAmount());
        outputView.generateBlank();
        outputView.showPurchasedLotto(
                lottoGameService.buyLotto(paymentAmount),
                lottoGameService.checkPurchasedLotto()
        );
    }

    private void generateWinningNumber() {
        String winningNumbers = inputView.enterWinningNumbers();
        int bonusWinningNumber = inputView.enterBonusWinningNumber();
        lottoGameService.completeMakingWinningNumber(winningNumbers, bonusWinningNumber);
    }
}
