package lotto.domain.service;

import java.util.List;
import lotto.domain.config.ScoreConfig;
import lotto.domain.entity.Order;
import lotto.domain.valueobject.Statistics;

public class StatisticsUpdateService {
    public void countWinningPoint(Order order, List<ScoreConfig> score) {
        Statistics statistics = order.getStatistics();
        statistics.incrementWinningCount(score);
    }
}
