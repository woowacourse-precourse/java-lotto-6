package lotto.domain;

import java.util.List;

public class Rsult {
//    구입 금액 / 당첨금액 * 100
//   소수 둘째 자리에서 반올림
    // 수익률
    public static double yield(int purchase, List<Rank> rank) {
        double result = (double) getYield(rank) / purchase * 100;
        return Math.round(result * 100.0) / 100.0;
    }
    public static double getYield(List<Rank> rank) {
        return rank.stream()
                .mapToDouble(Rank::getPrize)
                .sum();
    }
}
