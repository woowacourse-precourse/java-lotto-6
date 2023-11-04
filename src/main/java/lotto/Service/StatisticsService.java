package lotto.Service;

import java.text.NumberFormat;
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

        String formattedPercent = printEarningPercent(earningMoney, purchasePrice);
        outputView.printEarningPercent(formattedPercent);
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

    private String printEarningPercent(int earningMoney, int purchasePrice) {
        double earningPercent = calculateEarningPercent(earningMoney, purchasePrice);
        String formattedPercent = String.format("%.2f", earningPercent);

        // 소수점 둘째 자리가 0인 경우, 소수점 첫째 자리까지만 출력
        if (formattedPercent.endsWith("0")) {
            formattedPercent = formattedPercent.substring(0, formattedPercent.length() - 1);
        }

        //천 단위로 콤마 찍기
        NumberFormat numberFormat = NumberFormat.getInstance();
        formattedPercent = numberFormat.format(Double.parseDouble(formattedPercent));

        return formattedPercent;
    }

    private double calculateEarningPercent(int earningMoney, int purchasePrice) {
        return Math.round((double) earningMoney / purchasePrice * 100 * 100) / 100.0;
    }
}
