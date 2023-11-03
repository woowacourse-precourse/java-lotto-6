package lotto.domain;

import java.util.Map;
import lotto.constant.LottoConstant;

public class WinningStatistics {
    private final WinningResult winningResult;
    private final double totalProfitRate;

    public WinningStatistics(WinningResult winningResult) {
        this.winningResult = winningResult;
        this.totalProfitRate = calculateTotalProfitRate(winningResult);
    }

    private double calculateTotalProfitRate(WinningResult winningResult) {
        long totalPrizeMoney = calculateTotalPrizeMoney(winningResult);
        int totalPurchaseAmount = calculateTotalPurchaseAmount(winningResult);
        return ((double) totalPrizeMoney / totalPurchaseAmount) * 100;
    }

    private long calculateTotalPrizeMoney(WinningResult winningResult) {
        long totalPrizeMoney = 0L;
        Map<LottoRank, Integer> resultByLottoRank = winningResult.getResultByLottoRank();
        for (Map.Entry<LottoRank, Integer> entry : resultByLottoRank.entrySet()) {
            LottoRank lottoRank = entry.getKey();
            int count = entry.getValue();

            totalPrizeMoney += lottoRank.getPrize() * count;
        }
        return totalPrizeMoney;
    }

    private int calculateTotalPurchaseAmount(WinningResult winningResult) {
        int purchasedLotto = winningResult.getPurchasedLottoCount();
        return purchasedLotto * LottoConstant.LOTTO_PRICE;
    }

    public WinningResult getWinningResult() {
        return winningResult;
    }

    public double getTotalProfitRate() {
        return totalProfitRate;
    }

}
