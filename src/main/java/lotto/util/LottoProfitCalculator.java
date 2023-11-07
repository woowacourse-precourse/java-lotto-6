package lotto.util;

import java.util.List;
import lotto.domain.LottoRank;


public class LottoProfitCalculator {
    public static Double calculate(List<LottoRank> results) {
        int sum = results.stream()
                .mapToInt(LottoRank::getPrizeAmount)
                .sum();

        return Math.round(sum * 100.0) / 100.0;
    }
}
