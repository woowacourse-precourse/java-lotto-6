package lotto.model;

import java.util.Map;
import lotto.constant.LottoPrize;

public record LottoResult(Map<LottoPrize, Integer> prizesCount) {

    public Integer getTotalPrize() {
        Integer totalPrize = 0;
        for (LottoPrize lottoPrize : prizesCount.keySet()) {
            final Integer count = prizesCount.get(lottoPrize);
            totalPrize += count * lottoPrize.getPrize();
        }
        return totalPrize;
    }
}
