package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {

    private final LottoView lottoView;
    private List<Lotto> purchasedLottos;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void start() {
        int purchaseAmount = lottoView.getPurchaseAmount();
        List<Lotto> purchasedLottos = generateLottos(purchaseAmount);
        lottoView.displayPurchasedLottos(purchasedLottos);

        List<Integer> winnerNums = lottoView.getWinnerNums();
        int bonusNum = lottoView.getBonusNum();

        List<Integer> results = new ArrayList<>(Collections.nCopies(Result.values().length, 0));
        for (Lotto lotto : purchasedLottos) {
            Result result = lotto.match(winnerNums, bonusNum);
            int idx  = result.ordinal();
            results.set(idx, results.get(idx) + 1);
        }
        double earningRate = calucateEarningRate(results, purchaseAmount);
        lottoView.printResult(results, earningRate);

    }

    private List<Lotto> generateLottos(int purchaseAmount) {
        return null;
    }

    private double calucateEarningRate(List<Integer> results, int purchaseAmount) {
        return 0;
    }
}
