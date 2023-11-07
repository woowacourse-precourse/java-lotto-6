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
        buyLotto();
        generateWinningNumber();
        announceResult();
    }

    private void buyLotto() {
        int paymentAmount = Integer.parseInt(inputView.enterPaymentAmount());
        outputView.generateBlank();
        int purchasedLottoCount = lottoGameService.setUpLotto(paymentAmount);
        ArrayList<Lotto> purchasedAllLotto = lottoGameService.checkPurchasedLotto();
        outputView.showPurchasedLotto(purchasedLottoCount, purchasedAllLotto);
    }

    private void generateWinningNumber() {
        String winningNumbers = inputView.enterWinningNumbers();
        int bonusWinningNumber = inputView.enterBonusWinningNumber();
        lottoGameService.completeMakingWinningNumber(winningNumbers, bonusWinningNumber);
    }

    private void announceResult() {
        lottoGameService.makeWinningGrade();
        int[] winningGrade = lottoGameService.getWinningGrade();
        double profitRate = lottoGameService.calculateProfitRate(winningGrade);
        outputView.WinningGradeVisualization(winningGrade, profitRate);
    }
}
