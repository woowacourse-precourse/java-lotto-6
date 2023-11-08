package controller;

import model.Rank;
import model.Ranking;

import java.util.List;

public class YieldCalculator {
    private static final int INIT_NUMBER = 0;
    private static final int RATE_MULTIPLIER = 100;
    private static final int RATE_DIVISOR = 10;
    private static final int RATE_ADJUSTMENT = 10;

    private static final String RESULT_MESSAGE_FIRST = "총 수익률은 ";
    private static final String RESULT_MESSAGE_SECOND = "%입니다.";
    public static int totalPrize(Ranking ranking) {
        int sum = INIT_NUMBER;
        for (int prizeRank : ranking.getWinningDetails()) {
            sum += matchRank(prizeRank);
        }
        return sum;
    }

    private static int matchRank(int prizeRank) {
        Rank rank = null;
        for (Rank r : Rank.values()) {
            if (r.getRank() == prizeRank) {
                rank = r;
                break;
            }
        }
        if (rank == null) {
            return INIT_NUMBER;
        }
        return rank.getPrice();
    }

    public static double yieldcalculate(int total, int purchase) {
        double yield = (double) total / purchase;
        yield *= RATE_MULTIPLIER;
        yield = (double) Math.round(yield * RATE_ADJUSTMENT) / RATE_DIVISOR;
        System.out.println(RESULT_MESSAGE_FIRST + yield + RESULT_MESSAGE_SECOND);
        return yield;
    }
}
