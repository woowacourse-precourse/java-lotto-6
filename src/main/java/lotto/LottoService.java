package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private final int LOTTO_PRICE = 1000;

    public List<Lotto> generateLottos(int purchaseAmount) {
        int lottoNum = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<lottoNum; i++) {
            lottos.add(Lotto.create());
        }
        return lottos;
    }

    public List<Integer> getResults(List<Lotto> purchasedLottos, List<Integer> winnerNums, int bonusNum) {
        List<Integer> results = new ArrayList<>(Collections.nCopies(Result.values().length, 0));
        for (Lotto lotto : purchasedLottos) {
            Result result = lotto.match(winnerNums, bonusNum);
            int idx  = result.ordinal();
            results.set(idx, results.get(idx) + 1);
        }
        return results;
    }

    public double calculateEarningRate(List<Integer> results, int purchaseAmount) {
        double totalEarning = 0;
        for (Result result : Result.values()) {
            totalEarning += results.get(result.ordinal()) * result.getEarnings();
        }
        return (totalEarning / purchaseAmount) * 100;
    }
}
