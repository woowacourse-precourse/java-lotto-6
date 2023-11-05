package lotto.domain.service;

import java.util.List;
import lotto.domain.config.ScoreConfig;
import lotto.domain.entity.Order;
import lotto.domain.entity.Statistics;

public class StatisticsModifyService {
    public void countWinningPoint(Order order, List<ScoreConfig> score) {
        Statistics statistics = order.getStatistics();
        statistics.incrementWinningCount(score);
    }
}
