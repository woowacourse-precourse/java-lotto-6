package lotto.domain;

import java.util.List;

public class Result {
    public static double yield(int purchase, List<Rank> rank) {
        double result = getYield(rank) / purchase * 100;
        return Math.round(result * 100.0) / 100.0;
    }
    public static double getYield(List<Rank> rank) {
        return rank.stream()
                .mapToDouble(Rank::getPrize)
                .sum();
    }
}
