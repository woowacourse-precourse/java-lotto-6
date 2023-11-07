package lotto.model;

import lotto.model.enums.Prize;
import lotto.model.enums.Rank;

import java.util.List;

public class LottoPrizeManager {
    private LottoPrizeResult prizeResult;

    public LottoPrizeManager(LottoPrizeResult prizeResult) {
        this.prizeResult = prizeResult;
    }

    public void calculateTotalPrize(List<Integer> rankResult) {
        int rank = Rank.RANK1.getRank();
        for (int count : rankResult) {
            long prize = getPrizeOfRank(rank);
            prizeResult.addTotalPrize(prize * count);
            rank++;
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

    public double getRateOfReturn(int purchaseMoney) {
        long totalPrize = prizeResult.getTotalPrize();
        return (double) totalPrize / purchaseMoney * 100;
    }
}
