package lotto.service;

import lotto.domain.Match;

import java.util.Map;

public class TotalMarginCalculator {
    private final static int lottoPrice = 1000;
    private double totalPrice = 0;
    private double profitSum = 0;
    private double totalMargin = 0;

    public double totalMarginCalculator(Map<Match, Integer> matchCount) {
        marginCalculator(matchCount);

        return totalMargin;
    }

    private void marginCalculator(Map<Match, Integer> matchCount) {
        getTotalMargin(matchCount, Match.NONE);
        getTotalMargin(matchCount, Match.THREE);
        getTotalMargin(matchCount, Match.FOUR);
        getTotalMargin(matchCount, Match.FIVE);
        getTotalMargin(matchCount, Match.FIVE_BONUS);
        getTotalMargin(matchCount, Match.SIX);

        totalMargin = (profitSum / totalPrice) * 100;
    }

    private void getTotalMargin(Map<Match, Integer> matchCount, Match key) {
        addTotalPrice(matchCount, key);
        addProfitSum(matchCount, key);
    }

    private void addTotalPrice(Map<Match, Integer> matchCount, Match key) {
        if (matchCount.containsKey(key)) {
            totalPrice += matchCount.get(key) * lottoPrice;
        }
    }

    private void addProfitSum(Map<Match, Integer> matchCount, Match key) {
        if (matchCount.containsKey(key)) {
            profitSum += matchCount.get(key) * key.prizeMoney();
        }
    }
}
