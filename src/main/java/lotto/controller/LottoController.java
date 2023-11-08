package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.domain.PrizeStatistics;
import lotto.domain.WinningLotto;
import lotto.util.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        Price purchasePrice = InputView.getPurchasePrice();
        int purchaseCount = purchasePrice.calculateLottoCount();

        Lottos lottos = LottoGenerator.generateLottos(purchaseCount);

        OutputView.printLottoPurchaseCount(purchaseCount);
        OutputView.printAllLottoNumbers(lottos);

        WinningLotto winningLotto = InputView.getWinningLottoNumbers();
        PrizeStatistics prizeStatistics = lottos.calculatePrizeStatistics(winningLotto);
        Double rateOfReturn = prizeStatistics.calculateLottoRateOfReturn(purchasePrice);

        OutputView.printResults(prizeStatistics);
        OutputView.printTotalProfit(rateOfReturn);
    }

}
