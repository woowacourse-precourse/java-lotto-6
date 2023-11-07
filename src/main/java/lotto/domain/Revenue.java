package lotto.domain;

import java.util.Map;

import static lotto.constant.constant.*;

public class Revenue {


    public String calculateRevenue(int payment, Map<Integer, Integer> winningTicketsCount) {
        double revenue = winningTicketsCount.get(RANK_FIVE) * RANK_FIVE_REWARD + winningTicketsCount.get(RANK_FOUR) *
                RANK_FOUR_REWARD + winningTicketsCount.get(RANK_THREE) * RANK_THREE_REWARD + winningTicketsCount.get(RANK_TWO) *
                RANK_TWO_REWARD + winningTicketsCount.get(RANK_ONE) * RANK_ONE_REWARD;
        double temp = revenue / payment * PERCENTAGE;
        String revenueRate = String.format("%.1f", temp);
        return revenueRate;
    }
}
