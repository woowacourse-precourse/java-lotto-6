package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoGameService;
import lotto.view.input.InputView;
import lotto.view.output.OutputView;

import java.util.ArrayList;

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
        purchaseLotto();
        generateWinningNumber();
        announceGameResult();
    }

    private void purchaseLotto() {
        int paymentAmount = Integer.parseInt(inputView.enterPaymentAmount());
        outputView.generateBlank();
        int purchasedLottoCount = lottoGameService.setUpPurchasedLotto(paymentAmount);
        ArrayList<Lotto> purchasedAllLotto = lottoGameService.checkPurchasedLotto();
        outputView.printPurchasedLotto(purchasedLottoCount, purchasedAllLotto);
    }

    private void generateWinningNumber() {
        String winningNumbers = inputView.enterWinningNumbers();
        int bonusWinningNumber = inputView.enterBonusWinningNumber();
        lottoGameService.completeMakingWinningNumber(winningNumbers, bonusWinningNumber);
    }

    private void announceGameResult() {
        lottoGameService.makeWinningData();
        int[] winningData = lottoGameService.getWinningData();
        double profitRate = lottoGameService.calculateProfitRate(winningData);
        outputView.printLottoGameResult(winningData, profitRate);
    }
}
