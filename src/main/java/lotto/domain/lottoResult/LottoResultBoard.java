package lotto.domain.lottoResult;

import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.PurchaseAmount;

public class LottoResultBoard {

    public static final int NUMBER_PERCENT = 100;
    public final Map<LottoRank, Long> lottoRankBoard;

    private LottoResultBoard(final Map<LottoRank, Long> lottoRankBoard) {
        this.lottoRankBoard = lottoRankBoard;
    }

    public static LottoResultBoard of(final Map<LottoRank, Long> lottoRankBoard) {
        return new LottoResultBoard(lottoRankBoard);
    }

    public long findMatchCount(final LottoRank lottoRank) {
        return lottoRankBoard.get(lottoRank);
    }

    public long calculateWinningAmountSum() {
        long winningAmountSum = 0;

        for (Entry<LottoRank, Long> entrySet : lottoRankBoard.entrySet()) {
            long rank = entrySet.getKey().getWinningAmount();
            long count = entrySet.getValue();
            winningAmountSum += rank * count;
        }
        return winningAmountSum;
    }

    public double calculateProfitabilityPercent(final PurchaseAmount purchaseAmount) {
        long grossRevenue = calculateWinningAmountSum();
        int cost = purchaseAmount.getPurchaseAmount();
        double profitabilityRatio = (double) grossRevenue / cost;

        return profitabilityRatio * NUMBER_PERCENT;
    }
}
