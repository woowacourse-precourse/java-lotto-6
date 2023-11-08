package lotto.model;

import lotto.service.LottoPrize;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoPrize, Integer> resultMap;
    private int profitRate;

    public LottoResult() {
        this.resultMap = new HashMap<>();
    }

    public void addResult(LottoPrize prize, int count) {
        resultMap.put(prize, resultMap.getOrDefault(prize, 0) + count);
    }

    public Map<LottoPrize, Integer> getResultMap() {
        return resultMap;
    }
}
