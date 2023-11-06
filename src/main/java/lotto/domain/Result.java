package lotto.domain;

import lotto.domain.constants.LottoRank;
import lotto.domain.constants.LottoRule;

import java.util.Map;

public class Result {
    private final Map<LottoRank, Integer> result;

    public Result(Map<LottoRank, Integer> result) {
        this.result = result;
    }

    public double calculateLottoRateOfReturn() {
        return 0;
    }

    public double proceeds() {
        return result.entrySet()
                .stream()
                .mapToDouble(result -> result.getKey().getWinningAmount() * result.getValue())
                .sum();
    }

    public double totalBuyLottoAmount() {
        return result.values()
                .stream()
                .mapToDouble(amount -> amount * LottoRule.PRICE.getValue())
                .sum();
    }
}
