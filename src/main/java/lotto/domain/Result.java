package lotto.domain;

import lotto.domain.constants.LottoRank;

import java.util.Map;

public class Result {
    private final Map<LottoRank, Integer> result;

    public Result(Map<LottoRank, Integer> result) {
        this.result = result;
    }

    public double proceeds() {
        return result.entrySet()
                .stream()
                .mapToDouble(result -> result.getKey().getWinningAmount() * result.getValue())
                .sum();
    }
}
