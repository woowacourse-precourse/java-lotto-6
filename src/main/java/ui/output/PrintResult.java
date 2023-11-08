package ui.output;

import domain.LottoGame.LottoGameResult;
import java.util.Map;
import domain.LottoGame.CalculateTotalPrize;

public class PrintResult {
    public static void printResult(LottoGameResult result) {
        Map<Integer, Long> matchCounts = result.getMatchCounts();
        System.out.println("당첨 통계");
        System.out.println("---");
        PrintMatchResult.printMatchResult(matchCounts, 3, "3개 일치 (5,000원)");
        PrintMatchResult.printMatchResult(matchCounts, 4, "4개 일치 (50,000원)");
        PrintMatchResult.printMatchResult(matchCounts, 5, "5개 일치 (1,500,000원)");
        PrintMatchResult.printMatchResult(matchCounts, -1, "5개 일치, 보너스 볼 일치 (30,000,000원)");
        PrintMatchResult.printMatchResult(matchCounts, 6, "6개 일치 (2,000,000,000원)");

        double totalPrize = CalculateTotalPrize.calculateTotalPrize(matchCounts);
        double totalInvestment = matchCounts.values().stream().mapToLong(Long::longValue).sum() * 1000;
        double profitRate = (totalPrize / totalInvestment) * 100;

        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}

