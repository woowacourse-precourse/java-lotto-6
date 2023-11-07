package lotto;

import java.util.List;
import lotto.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoWinningProcess lottoWinningProcess = new LottoWinningProcess();
        PurchaseMoney purchaseMoney = lottoWinningProcess.setUpPurchaseMoney();
        List<Lotto> lottos = lottoWinningProcess.buyLotto(purchaseMoney);
        LottoResult lottoResult = lottoWinningProcess.run(lottos);
        OutputView.printStatistics(lottoResult.getFinalResult());
        double earningRate = lottoResult.calculateEarningRate(purchaseMoney.getAmount());
        OutputView.printEarningRate(earningRate);
    }
}