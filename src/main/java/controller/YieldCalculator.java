package controller;

import model.Rank;
import model.Ranking;

import java.util.List;

public class YieldCalculator {

    public static int totalPrize(Ranking ranking) {
        int sum = 0;
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
            return 0;
        }
        return rank.getPrice();
    }

    public static double yieldcalculate(int total, int purchase) {
        double yield = (double) total / purchase;
        yield *= 100;
        yield = (double) Math.round(yield * 10) / 10;
        System.out.println("총 수익률은 " + yield + "%입니다.");
        return yield;
    }
}
