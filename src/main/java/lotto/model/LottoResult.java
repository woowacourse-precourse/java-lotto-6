package lotto.model;

import lotto.service.LottoPrize;

import java.util.HashMap;

public class LottoResult {
    private final HashMap<LottoPrize, Integer> resultMap;
    private int profit;

    public LottoResult() {
        this.resultMap = new HashMap<>();
        this.profit = 0;
    }

    public void addResult(LottoPrize prize, int count) {
        resultMap.put(prize, resultMap.getOrDefault(prize, 0) + count);
        if (count > 0) {
            profit += (count * prize.getPrizeAmount());
        }
    }

    public HashMap<LottoPrize, Integer> getResultMap() {
        return resultMap;
    }

    public int getProfit() {
        return profit;
    }
}
