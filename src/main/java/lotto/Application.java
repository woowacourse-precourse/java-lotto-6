package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoWinningProcess lottoWinningProcess = new LottoWinningProcess();
        PurchaseMoney purchaseMoney = lottoWinningProcess.setUpPurchaseMoney();
        List<Lotto> lottos = lottoWinningProcess.buyLotto(purchaseMoney);
        LottoResult lottoResult = lottoWinningProcess.run(lottos);

        double earningRate = lottoResult.calculateEarningRate(purchaseMoney.getLottoQuantity());
    }
}