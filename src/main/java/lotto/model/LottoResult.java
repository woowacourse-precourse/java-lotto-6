package lotto.model;

import lotto.service.LottoPrizeMessage;

import java.util.HashMap;

public class LottoResult {
    private final HashMap<LottoPrizeMessage, Integer> resultMap;
    private int profit;

    public LottoResult() {
        this.resultMap = new HashMap<>();
        this.profit = LottoConstants.LOTTO_PROFIT_START_NUMBER;
    }

    public void addResult(LottoPrizeMessage prize, int count) {
        resultMap.put(prize, resultMap.getOrDefault(prize, LottoConstants.LOTTO_PRIZE_START_NUMBER) + count);
        calculateProfit(prize, count);
    }

    private void calculateProfit(LottoPrizeMessage prize, int count) {
        if (count > LottoConstants.NO_COUNT) {
            profit += (count * prize.getPrizeAmount());
        }
    }

    public HashMap<LottoPrizeMessage, Integer> getResultMap() {
        return resultMap;
    }

    public int getProfit() {
        return profit;
    }
}
