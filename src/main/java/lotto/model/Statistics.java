package lotto.model;

import lotto.enums.StatisticsInfo;

import java.util.ArrayList;

import static lotto.enums.StatisticsInfo.RANK_1;
import static lotto.enums.StatisticsInfo.RANK_2;
import static lotto.enums.StatisticsInfo.RANK_3;
import static lotto.enums.StatisticsInfo.RANK_4;
import static lotto.enums.StatisticsInfo.RANK_5;

public record Statistics(
        Integer rank1,
        Integer rank2,
        Integer rank3,
        Integer rank4,
        Integer rank5,
        Integer purchaseAmount
) {
    private static final int CALC_PERCENT = 100;

    public Statistics(ArrayList<Integer> rankCount, Integer purchaseAmount) {
        this(
                rankCount.get(RANK_1.ordinal()),
                rankCount.get(RANK_2.ordinal()),
                rankCount.get(RANK_3.ordinal()),
                rankCount.get(RANK_4.ordinal()),
                rankCount.get(RANK_5.ordinal()),
                purchaseAmount
        );
    }

    public Integer getCount(Integer rank) {
        if (rank == RANK_1.getRank()) return rank1;
        if (rank == RANK_2.getRank()) return rank2;
        if (rank == RANK_3.getRank()) return rank3;
        if (rank == RANK_4.getRank()) return rank4;
        if (rank == RANK_5.getRank()) return rank5;
        return 0;
    }

    public double getProfit() {
        return (getTotalPrizeMoney() / purchaseAmount) * CALC_PERCENT;
    }

    private double getTotalPrizeMoney() {
        return (rank1 * StatisticsInfo.RANK_1.getPrizeMoney())
                + (rank2 * StatisticsInfo.RANK_2.getPrizeMoney())
                + (rank3 * StatisticsInfo.RANK_3.getPrizeMoney())
                + (rank4 * StatisticsInfo.RANK_4.getPrizeMoney())
                + (rank5 * StatisticsInfo.RANK_5.getPrizeMoney());
    }
}
