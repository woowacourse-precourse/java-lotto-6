package lotto.model;

import lotto.model.enums.Prize;
import lotto.model.enums.Rank;

public class LottoPrizeManager {
    private LottoRankResult rankResult;
    private LottoPrizeResult prizeResult;

    public LottoPrizeManager(LottoRankResult rankResult, LottoPrizeResult prizeResult) {
        this.rankResult = rankResult;
        this.prizeResult = prizeResult;
    }

    public void calculateTotalPrize() {
        for (int rank = Rank.RANK1.getRank(); rank <= Rank.RANK5.getRank(); rank++) {
            long prize = getPrizeOfRank(rank);
            int rankCount = rankResult.getCount(rank);
            prizeResult.addTotalPrize(prize * rankCount);
        }
    }

    private long getPrizeOfRank(int rank) {
        for (Prize prize : Prize.values()) {
            if (prize.isMatch(rank)) {
                return prize.getPrize();
            }
        }
        return Prize.NO_PRIZE.getPrize();
    }

    public long getTotalPrize() {
        return prizeResult.getTotalPrize();
    }
}
