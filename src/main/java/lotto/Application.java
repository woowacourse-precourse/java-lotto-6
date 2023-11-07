package lotto;

import java.util.List;
import lotto.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoWinningProcess lottoWinningProcess = new LottoWinningProcess();
        PurchaseMoney purchaseMoney = lottoWinningProcess.one();

        List<Lotto> lottos = lottoWinningProcess.buyLotto(purchaseMoney);
        Lotto winningNumber = lottoWinningProcess.two();
        WinningLotto winningLotto = lottoWinningProcess.three(winningNumber);
        LottoResult lottoResult = lottoWinningProcess.run(lottos, winningLotto);

        OutputView.printStatistics(lottoResult.getFinalResult());

        double earningRate = lottoResult.calculateEarningRate(purchaseMoney.getAmount());
        OutputView.printEarningRate(earningRate);
    }
}