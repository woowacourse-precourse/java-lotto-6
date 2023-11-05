package lotto.domain.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import lotto.domain.config.ScoreConfig;

public class Statistics {
    private Map<ScoreConfig, Integer> winning;

    public Statistics() {
        this.winning = new HashMap<>();
        for (ScoreConfig score : ScoreConfig.values()) {
            winning.put(score, 0);
        }
    }

    public Map<ScoreConfig, Integer> getWinning() {
        return winning;
    }

    public Integer getRevenue() {
        AtomicInteger revenue = new AtomicInteger();
        winning.forEach((key, value) -> revenue.addAndGet(key.getReward() * value));
        return revenue.get();
    }
}
