package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {

    private final int LOTTO_PRICE = 1000;
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
        List<Integer> results = getResults(purchasedLottos, winnerNums, bonusNum);
        double earningRate = calculateEarningRate(results, purchaseAmount);
        lottoView.printResult(results, earningRate);

    }

    private List<Lotto> generateLottos(int purchaseAmount) {
        int lottoNum = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<lottoNum; i++) {
            lottos.add(Lotto.create());
        }
        return lottos;
    }

    private static List<Integer> getResults(List<Lotto> purchasedLottos, List<Integer> winnerNums, int bonusNum) {
        List<Integer> results = new ArrayList<>(Collections.nCopies(Result.values().length, 0));
        for (Lotto lotto : purchasedLottos) {
            Result result = lotto.match(winnerNums, bonusNum);
            int idx  = result.ordinal();
            results.set(idx, results.get(idx) + 1);
        }
        return results;
    }

    private double calculateEarningRate(List<Integer> results, int purchaseAmount) {
        double totalEarning = 0;
        for (Result result : Result.values()) {
            totalEarning += results.get(result.ordinal()) * result.getEarnings();
        }
        return (totalEarning / purchaseAmount) * 100;
    }
}
