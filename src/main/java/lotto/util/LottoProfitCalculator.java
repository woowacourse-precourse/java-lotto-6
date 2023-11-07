package lotto.util;

import java.util.List;
import lotto.domain.LottoRank;


public class LottoProfitCalculator {
    public static Double calculate(List<LottoRank> results, Integer totalPrice) {
        int sum = results.stream()
                .mapToInt(LottoRank::getPrizeAmount)
                .sum();

        double roi = (double) (sum * 100) / totalPrice;
        return Math.round(roi * 100.0) / 100.0; // 소수점 둘째 자리에서 반올림
    }
}
