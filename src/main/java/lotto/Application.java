package lotto;

import java.util.List;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoPreparation lottoPreparation = new LottoPreparation();
        LottoProcess lottoProcess = new LottoProcess();
        PurchaseMoney purchaseMoney = lottoPreparation.setUpPurchaseMoney(InputView.inputPurchaseMoney());
        int lottoQuantity = purchaseMoney.getLottoQuantity();
        List<Lotto> lottos = lottoProcess.buyLotto(lottoQuantity);

        OutputView.printLottoQuantity(lottoQuantity);
        OutputView.printLottos(lottos);

        Lotto winningNumber = lottoPreparation.setUpWinningNumbers(InputView.inputWinningNumbers());
        WinningLotto winningLotto = lottoProcess.runWinningLottoStep(winningNumber);
        LottoResult lottoResult = lottoProcess.run(lottos, winningLotto);
        double earningRate = lottoResult.calculateEarningRate(purchaseMoney.getAmount());
        OutputView.printStatistics(lottoResult.getFinalResult());
        OutputView.printEarningRate(earningRate);
    }
}