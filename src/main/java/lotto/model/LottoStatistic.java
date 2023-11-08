package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistic {
    private final Map<LottoPrize, Integer> lottoStatistic;
    private double yield;

    public LottoStatistic() {
        this.lottoStatistic = new HashMap<>();
    }

    public Map<LottoPrize, Integer> getLottoStatistic() {
        return new HashMap<>(this.lottoStatistic);
    }

    public void addStatistic(LottoPrize prize) {
        lottoStatistic.put(
            prize,
            lottoStatistic.getOrDefault(prize, 0) + 1
        );
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public double getYield() {
        return this.yield;
    }
}
