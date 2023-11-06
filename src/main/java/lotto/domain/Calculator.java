package lotto.domain;

import lotto.constants.Rank;

import java.util.Collections;
import java.util.List;

import static lotto.domain.Controller.LOTTERY_PRICE;

public class Calculator {

    public static Integer calculateTotalPrize(List<Rank> rankList) {
        Integer totalPrize = 0;
        for (Rank rank : Rank.values()) {
            int rankFrequency = Collections.frequency(rankList, rank);
            totalPrize += rank.calculatePrizeByRank(rankFrequency);
        }
        return totalPrize;
    }

    public static Double calculatePricePrizeRatio(Integer totalPrize, Integer price) {
        return (double) totalPrize / price * 100;
    }

    public static Integer calculateLotteryCount(Integer budget) {
        return budget / LOTTERY_PRICE;
    }
}
