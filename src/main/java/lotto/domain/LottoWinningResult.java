package lotto.domain;

import java.util.Map;

public class LottoWinningResult {

    private final LottoPurchase lottoPurchase;
    private final Map<LottoPrize, Integer> prizeCountMap;

    public LottoWinningResult(LottoPurchase lottoPurchase, Map<LottoPrize, Integer> prizeCountMap) {
        this.lottoPurchase = lottoPurchase;
        this.prizeCountMap = prizeCountMap;
    }

    private long calculateLottoWinningAmount() {
        long lottoWinningAmount = 0L;
        for (LottoPrize lottoPrize : prizeCountMap.keySet()) {
            int numOfWins = prizeCountMap.getOrDefault(lottoPrize, 0);
            lottoWinningAmount += lottoPrize.getWinningAmount();
            this.prizeCountMap.put(lottoPrize, numOfWins);
        }
        return lottoWinningAmount;
    }

    public double calculateRewardRatio() {
        long purchaseAmount = lottoPurchase.getPurchaseAmount();
        long lottoWinningAmount = calculateLottoWinningAmount();

        return (double) lottoWinningAmount / purchaseAmount;
    }

    public Map<LottoPrize, Integer> getTable() {
        return prizeCountMap;
    }
}
