package lotto;

import java.util.List;
import lotto.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoProcess lottoProcess = new LottoProcess();
        PurchaseMoney purchaseMoney = lottoProcess.runPurchaseMoneyStep();
        int lottoQuantity = purchaseMoney.getLottoQuantity();

        OutputView.printLottoQuantity(lottoQuantity);

        List<Lotto> lottos = lottoProcess.buyLotto(purchaseMoney, lottoQuantity);
        Lotto winningNumber = lottoProcess.runWinningNumbersStep();
        WinningLotto winningLotto = lottoProcess.runWinningLottoStep(winningNumber);
        LottoResult lottoResult = lottoProcess.run(lottos, winningLotto);

        OutputView.printStatistics(lottoResult.getFinalResult());

        double earningRate = lottoResult.calculateEarningRate(purchaseMoney.getAmount());
        OutputView.printEarningRate(earningRate);
    }
}