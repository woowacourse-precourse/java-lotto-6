package lotto;

import java.util.List;
import lotto.ui.OutputView;

public class Application {
    private static final String ERROR_PREFIX = "[ERROR] ";
    public static void main(String[] args) {
        try {
            LottoWinningProcess lottoWinningProcess = new LottoWinningProcess();
            PurchaseMoney purchaseMoney = lottoWinningProcess.setUpPurchaseMoney();
            List<Lotto> lottos = lottoWinningProcess.buyLotto(purchaseMoney);
            LottoResult lottoResult = lottoWinningProcess.run(lottos);
            OutputView.printStatistics(lottoResult.getFinalResult());
            double earningRate = lottoResult.calculateEarningRate(purchaseMoney.getAmount());
            OutputView.printEarningRate(earningRate);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
        }
    }
}