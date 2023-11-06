package lotto.domain;

import java.util.Map;

public class LottoWinningResult {

    private final LottoPurchase lottoPurchase;
    private final Map<LottoPrize, Integer> prizeCounts;

    public LottoWinningResult(LottoPurchase lottoPurchase, Map<LottoPrize, Integer> prizeCounts) {
        this.lottoPurchase = lottoPurchase;
        this.prizeCounts = prizeCounts;
    }

    private long calculateLottoWinningAmount() {
        long lottoWinningAmount = 0L;
        for (LottoPrize lottoPrize : prizeCounts.keySet()) {
            int numOfWins = prizeCounts.getOrDefault(lottoPrize, 0);
            lottoWinningAmount += lottoPrize.getWinningAmount();
            this.prizeCounts.put(lottoPrize, numOfWins);
        }
        return lottoWinningAmount;
    }

    public double calculateRewardRatio() {
        long purchaseAmount = lottoPurchase.getPurchaseAmount();
        long lottoWinningAmount = calculateLottoWinningAmount();

        return (double) lottoWinningAmount / purchaseAmount;
    }

    public Map<LottoPrize, Integer> getprizeCounts() {
        return prizeCounts;
    }
}
