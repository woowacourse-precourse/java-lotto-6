package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lottos;
import lotto.model.ProfitRate;
import lotto.model.PurchaseAmount;
import lotto.model.WinningLotto;
import lotto.model.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        PurchaseAmount purchaseAmount = createPurchaseAmount();

        Lottos lottos = createLottos(purchaseAmount);
        lottos.displayLottos();

        WinningLotto winningLotto = new WinningLotto();

        WinningResult winningResult = lottos.calculateWinningResult(winningLotto);
        winningResult.displayWinningResult();

        ProfitRate profitRate = winningResult.calculateProfitRate();
        profitRate.displayProfitRate();

        Console.close();
    }

    private Lottos createLottos(PurchaseAmount purchaseAmount) {
        return new Lottos(purchaseAmount);
    }

    private PurchaseAmount createPurchaseAmount() {
        do {
            try {
                return new PurchaseAmount(readPurchaseAmount());
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessage(e.getMessage());
            }
        } while (true);
    }

    private int readPurchaseAmount() {
        return InputView.readPurchaseAmount();
    }
}
