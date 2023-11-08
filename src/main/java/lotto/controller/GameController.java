package lotto.controller;

import java.util.List;
import lotto.model.Lotteries;
import lotto.model.Lotto;
import lotto.model.LottoMatcher;
import lotto.view.OutputMessage;

public class GameController {
    public void play() {
        int purchasePrice = InputController.getPurchasePrice();

        Lotteries lotteries = new Lotteries(purchasePrice);
        List<Lotto> lottos = lotteries.purchaseLotto();
        OutputMessage.printPurchaseAmount(purchasePrice, lotteries.getLottos());

        List<Integer> winningNumber = InputController.getWinningNumber();
        int bonusNumber = InputController.getBounusNumber();

        LottoMatcher lottoMatcher = new LottoMatcher(lottos, winningNumber, bonusNumber);
        OutputMessage.printResult(lottoMatcher.getStatistics(), lottoMatcher.getProfitRate());
    }


}
