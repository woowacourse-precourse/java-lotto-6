package lotto;

import java.util.List;
import lotto.ui.OutputView;

public class Application {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void main(String[] args) {
        LottoWinningProcess lottoWinningProcess = new LottoWinningProcess();
        PurchaseMoney purchaseMoney = one(lottoWinningProcess);
        List<Lotto> lottos = lottoWinningProcess.buyLotto(purchaseMoney);
        Lotto winningNumber = two(lottoWinningProcess);
        WinningLotto winningLotto = three(lottoWinningProcess, winningNumber);
        LottoResult lottoResult = lottoWinningProcess.run(lottos, winningLotto);
        OutputView.printStatistics(lottoResult.getFinalResult());
        double earningRate = lottoResult.calculateEarningRate(purchaseMoney.getAmount());
        OutputView.printEarningRate(earningRate);
    }

    private static PurchaseMoney one(LottoWinningProcess lottoWinningProcess) {
        try {
            return lottoWinningProcess.setUpPurchaseMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
        }
        return one(lottoWinningProcess);
    }

    private static Lotto two(LottoWinningProcess lottoWinningProcess) {
        try {
            return lottoWinningProcess.setUpWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
        }
        return two(lottoWinningProcess);
    }

    private static WinningLotto three(LottoWinningProcess lottoWinningProcess, Lotto winningNumber) {
        try {
            return lottoWinningProcess.setUpWinningLotto(winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
        }
        return three(lottoWinningProcess, winningNumber);
    }
}