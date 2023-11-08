package lotto.domain;

import java.util.HashMap;
import java.util.Set;

public class LottoResult {

    private static final int DEFAULT_VALUE = 0;
    private static final int ADD_COUNT = 1;
    private static final int PERCENT = 100;

    private final HashMap<LottoRanking, Integer> results;
    private final PurchaseAmount purchaseAmount;


    public LottoResult(Lottos lottos, WinningNumber winningNumber, BonusNumber bonusNumber, PurchaseAmount purchaseAmount) {
        HashMap<LottoRanking, Integer> results = new HashMap<>();

        for (Lotto lotto : lottos.getLottos()) {
            LottoRanking ranking = LottoRanking.getLottoRanking(winningNumber.winningNumberCount(lotto), bonusNumber.bonusNumberMatch(lotto));
            results.put(ranking, results.getOrDefault(ranking, DEFAULT_VALUE) + ADD_COUNT);
        }

        this.purchaseAmount = purchaseAmount;
        this.results = results;
    }

    public Integer getResult(LottoRanking key) {
        return results.getOrDefault(key, DEFAULT_VALUE);
    }
}
