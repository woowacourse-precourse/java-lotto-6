package lotto.controller;

import lotto.model.Lotto;
import lotto.model.PrizeRank;
import lotto.model.WinningLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;
import java.util.List;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(LottoService lottoService, InputView inputView, ResultView resultView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        try {
            int purchaseAmount = inputView.promptForPurchaseAmount();
            List<Lotto> purchasedLottos = lottoService.purchaseLottos(purchaseAmount);
            resultView.displayPurchasedLottos(purchasedLottos);

            List<Integer> winningNumbers = inputView.promptForWinningNumbers();
            int bonusNumber = inputView.promptForBonusNumber(winningNumbers);
            WinningLotto winningLotto = lottoService.generateWinningLotto(winningNumbers, bonusNumber);

            List<PrizeRank> prizeRanks = lottoService.determinePrizeRank(purchasedLottos, winningLotto);
            resultView.displayWinningStatistics(prizeRanks);

            double totalPrize = lottoService.calculateTotalPrize(prizeRanks);
            double rateOfReturn = lottoService.calculateRateOfReturn(purchaseAmount, totalPrize);
            resultView.displayRateOfReturn(rateOfReturn);
        } catch (IllegalArgumentException e) {
            resultView.displayError(e.getMessage());
        }
    }
}
