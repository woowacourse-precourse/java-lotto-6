package lotto.domain;

import java.util.List;

public class Rsult {
//    구입 금액 / 당첨금액 * 100
//   소수 둘째 자리에서 반올림
    // 수익률
    public static String yield(int purchase, List<Rank> rank) {
        return String.format("%.2f", purchase / getYield(rank) * 100);
    }
    public static double getYield(List<Rank> rank) {
        return rank.stream()
                .mapToDouble(Rank::getPrize)
                .sum();
    }
}
