package lotto.domain;

import java.util.Map;

public class LottoWinningResult {

    private final double rewardRatio;
    private final Map<LottoPrize, Integer> prizeCountMap;

    public LottoWinningResult(LottoPurchase lottoPurchase, Map<LottoPrize, Integer> prizeCountMap) {
        this.prizeCountMap = prizeCountMap;
        long purchaseAmount = lottoPurchase.getPurchaseAmount();
        long lottoWinningAmount = calculateLottoWinningAmount();

        this.rewardRatio = (double) lottoWinningAmount / purchaseAmount;
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

    public double getRewardRatio() {
        return rewardRatio;
    }

    public Map<LottoPrize, Integer> getTable() {
        return prizeCountMap;
    }
}
