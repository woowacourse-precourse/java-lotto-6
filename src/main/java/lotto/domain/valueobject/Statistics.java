package lotto.domain.valueobject;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import lotto.domain.config.ScoreConfig;

public class Statistics {
    private static final int INIT_ZERO = 0;
    private static final int COUNTING = 1;
    private Map<ScoreConfig, Integer> winning;

    public Statistics() {
        this.winning = new HashMap<>();
        for (ScoreConfig score : ScoreConfig.values()) {
            winning.put(score, INIT_ZERO);
        }
    }

    public void incrementWinningCount(List<ScoreConfig> scores) {
        for (ScoreConfig score : scores) {
            winning.compute(score, (key, winningCount) -> winningCount + COUNTING);
        }
    }

    public List<ScoreConfig> getScores() {
        List<ScoreConfig> scores = Arrays.asList(ScoreConfig.values());
        Collections.reverse(scores);
        return scores;
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
