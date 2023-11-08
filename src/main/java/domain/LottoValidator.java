package domain;

import enums.LottoScore;

import java.util.Map;

public class LottoValidator {
    public void printResult(Map<LottoScore, Integer> scoreCountMap) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        printSingleResult(scoreCountMap, LottoScore.FIFTH, "3개 일치 (5,000원)");
        printSingleResult(scoreCountMap, LottoScore.FOURTH, "4개 일치 (50,000원)");
        printSingleResult(scoreCountMap, LottoScore.THIRD, "5개 일치 (1,500,000원)");
        printSingleResult(scoreCountMap, LottoScore.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원)");
        printSingleResult(scoreCountMap, LottoScore.FIRST, "6개 일치 (2,000,000,000원)");
    }

    private void printSingleResult(Map<LottoScore, Integer> scoreCountMap, LottoScore score, String prizeText) {
        int count = scoreCountMap.getOrDefault(score, 0);
        System.out.println(prizeText + " - " + count + "개");
    }

    public long calculateTotalPrize(Map<LottoScore, Integer> scoreCountMap) {
        long totalPrize = 0;

        for (LottoScore score : LottoScore.values()) {
            int count = scoreCountMap.getOrDefault(score, 0);
            totalPrize += (long) count * score.getPrizeMoney();
        }

        return totalPrize;
    }

    public double calculateProfitRate(long totalPrize, int purchaseAmount) {
        double profitRate = (double) totalPrize / purchaseAmount * 100;
        return Math.round(profitRate * 10) / 10.0;
    }
}
