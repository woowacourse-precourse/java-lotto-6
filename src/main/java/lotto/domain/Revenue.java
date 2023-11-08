package lotto.domain;

import java.util.Map;

import static lotto.constant.constant.*;

public class Revenue {


    public String calculateRevenue(int payment, Map<Integer, Integer> winningTicketsCount) {
        double revenue = winningTicketsCount.get(Rank.FIFTH.ordinal()) * RANK_FIVE_REWARD + winningTicketsCount.get(Rank.FOURTH.ordinal()) *
                RANK_FOUR_REWARD + winningTicketsCount.get(Rank.THIRD.ordinal()) * RANK_THREE_REWARD + winningTicketsCount.get(Rank.SECOND.ordinal()) *
                RANK_TWO_REWARD + winningTicketsCount.get(Rank.FIRST.ordinal()) * RANK_ONE_REWARD;
        double temp = revenue / payment * PERCENTAGE;
        String revenueRate = String.format("%.1f", temp);
        return revenueRate;
    }

}
