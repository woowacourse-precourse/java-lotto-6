package lotto.Service;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.CompareResult;
import lotto.model.RankMoney;
import lotto.view.output.OutputView;

public class StatisticsService {
    private OutputView outputView;

    public StatisticsService(OutputView outputView) {
        this.outputView = outputView;
    }

    public String calculateStatistics(List<CompareResult> result, int purchasePrice) {
        //로또 통계
        Map<CompareResult, Integer> matchingCount = new HashMap<>();
        RankMoney rankMoney = new RankMoney();

        // 일치률 계산
        updateMatchingCount(result, matchingCount);
        // 상금 계산
        int earningMoney = calculatePrize(matchingCount, rankMoney);

        outputView.printWinningStatistics();
        outputView.printMatchingCount(matchingCount);

        String formattedPercent = printEarningPercent(earningMoney, purchasePrice);
        outputView.printEarningPercent(formattedPercent);

        return formattedPercent;
    }

    private void updateMatchingCount(List<CompareResult> result, Map<CompareResult, Integer> matchingCount) {
        for (CompareResult compareResult : result) {
            CompareResult matchCount = new CompareResult(compareResult.getMatchCount(), compareResult.isMatchBonus());
            int currentCount = matchingCount.getOrDefault(matchCount, 0);
            matchingCount.put(matchCount, currentCount + 1);
        }
    }

    private int calculatePrize(Map<CompareResult, Integer> matchingCount, RankMoney rankMoney) {
        int earningMoney = 0;

        for (CompareResult compareResult : matchingCount.keySet()) {
            CompareResult matchCount = new CompareResult(compareResult.getMatchCount(), compareResult.isMatchBonus());
            earningMoney += rankMoney.getPrizeMoney(matchCount.getMatchCount());
            earningMoney += rankMoney.getBonusPrizeMoney(matchCount.getMatchCount(), compareResult.isMatchBonus());
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
