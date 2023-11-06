package lotto.dto;

import java.util.HashMap;
import java.util.Map;
import lotto.LottoPrize;

public class LottoWinningStatistics {

    private final double rewardRatio;
    private final Map<LottoPrize, Integer> table = new HashMap<>();

    public LottoWinningStatistics(long purchaseAmount, Map<LottoPrize, Integer> prizeTable) {
        long lottoWinningAmount = calculateLottoWinningAmount(prizeTable);
        rewardRatio = (double) lottoWinningAmount / purchaseAmount;
    }

    private long calculateLottoWinningAmount(Map<LottoPrize, Integer> prizeTable) {
        long lottoWinningAmount = 0L;
        for (LottoPrize lottoPrize : prizeTable.keySet()) {
            int numOfWins = prizeTable.getOrDefault(lottoPrize, 0);
            lottoWinningAmount += lottoPrize.getWinningAmount();
            this.table.put(lottoPrize, numOfWins);
        }
        return lottoWinningAmount;
    }

    public double getRewardRatio() {
        return rewardRatio;
    }

    public int getCountLottoPrize(LottoPrize lottoPrize) {
        return table.getOrDefault(lottoPrize, 0);
    }
}
