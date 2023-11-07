package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistic {
    private final Map<LottoPrize, Integer> lottoStatistic;

    public LottoStatistic() {
        this.lottoStatistic = new HashMap<>();
    }

    public LottoStatistic(LottoStatistic lottoStatistic) {
        this.lottoStatistic = lottoStatistic.getLottoStatistic();
    }

    public Map<LottoPrize, Integer> getLottoStatistic() {
        return lottoStatistic;
    }

    public void addStatistic(LottoPrize prize) {
        lottoStatistic.put(
            prize,
            lottoStatistic.getOrDefault(prize, 0) + 1
        );
    }
}
