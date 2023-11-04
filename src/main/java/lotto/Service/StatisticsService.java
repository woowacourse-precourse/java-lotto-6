package lotto.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.PrizeMoney;
import lotto.model.Statistics;
import lotto.view.output.OutputView;

public class StatisticsService {
    private OutputView outputView;

    public StatisticsService(OutputView outputView) {
        this.outputView = outputView;
    }

    public void calculateStatistics(List<Statistics> result, int purchasePrice) {
        //로또 통계
        Map<Statistics, Integer> matchingCount = new HashMap<>();
        PrizeMoney prizeMoney = new PrizeMoney();

        // 일치률 계산
        updateMatchingCount(result, matchingCount);
        // 상금 계산
        int earningMoney = calculateStatistics(result, matchingCount, prizeMoney);

        outputView.printWinningStatistics();
        outputView.printMatchingCount(matchingCount);
        outputView.printEarningPercent(earningMoney, purchasePrice);
    }
    
    private void updateMatchingCount(List<Statistics> result, Map<Statistics, Integer> matchingCount) {
        for (Statistics statistics : result) {
            Statistics matchCount = new Statistics(statistics.getMatchCount(), statistics.isMatchBonus());
            int currentCount = matchingCount.getOrDefault(matchCount, 0);
            matchingCount.put(matchCount, currentCount + 1);
        }
    }

    private int calculateStatistics(List<Statistics> result, Map<Statistics, Integer> matchingCount,
                                    PrizeMoney prizeMoney) {
        int earningMoney = 0;

        for (Statistics statistics : result) {
            Statistics matchCount = new Statistics(statistics.getMatchCount(), statistics.isMatchBonus());
            earningMoney += prizeMoney.getPrizeMoney(matchCount.getMatchCount());
            earningMoney += prizeMoney.getBonusPrizeMoney(matchCount.getMatchCount(), statistics.isMatchBonus());
        }
        return earningMoney;
    }
}
