package lotto.model;

import java.util.Map;
import lotto.constant.LottoPrize;

public class LottoResult {

    private final Map<LottoPrize, Integer> prizesCount;

    public LottoResult(Map<LottoPrize, Integer> prizesCount) {
        this.prizesCount = prizesCount;
    }

    public Map<LottoPrize, Integer> getPrizesCount() {
        return prizesCount;
    }
}
