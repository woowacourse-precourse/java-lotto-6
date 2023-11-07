package lotto.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.domain.LottoRank;


public class LottoProfitCalculator {
    public static BigDecimal calculate(List<LottoRank> lottoRanks, Integer totalPrice) {

        BigDecimal sum = lottoRanks.stream()
                .map(lottoRank -> new BigDecimal(lottoRank.getPrizeAmount()))
                .reduce(new BigDecimal(0), BigDecimal::add);


        BigDecimal roi = sum.multiply(new BigDecimal(100)).divide(new BigDecimal(totalPrice), 1, RoundingMode.HALF_UP);
        return roi.stripTrailingZeros();
    }
}
