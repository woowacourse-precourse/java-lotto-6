package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    private static final Map<MatchResult, Integer> PRIZE_MONEY = new HashMap<>();

    static {
        PRIZE_MONEY.put(new MatchResult(3, false), 5_000);
        PRIZE_MONEY.put(new MatchResult(4, false), 50_000);
        PRIZE_MONEY.put(new MatchResult(5, false), 1_500_000);
        PRIZE_MONEY.put(new MatchResult(5, true), 30_000_000);
        PRIZE_MONEY.put(new MatchResult(6, false), 2_000_000_000);
    }

    private final int totalAmount;
    private final List<MatchResult> matchResults;

    public Statistics(int totalAmount, List<MatchResult> matchResults) {
        this.totalAmount = totalAmount;
        this.matchResults = matchResults;
    }

    public void evaluateTotalProfit() {
        // 각 MatchResult에 대한 카운트를 저장할 맵
        Map<MatchResult, Integer> counts = new HashMap<>();
        float totalWinnings = 0;

        // 각 MatchResult의 카운트를 계산
        for (MatchResult matchResult : matchResults) {
            counts.put(matchResult, counts.getOrDefault(matchResult, 0) + 1);
            totalWinnings += PRIZE_MONEY.getOrDefault(matchResult, 0);
        }

        // 결과 출력
        System.out.println("당첨 통계\n---");
        for (int matchCount = 3; matchCount <= 6; matchCount++) {
            MatchResult matchResultWithoutBonus = new MatchResult(matchCount, false);
            MatchResult matchResultWithBonus = new MatchResult(matchCount, true);

            int countWithoutBonus = counts.getOrDefault(matchResultWithoutBonus, 0);
            int countWithBonus = counts.getOrDefault(matchResultWithBonus, 0);

            System.out.printf("%d개 일치 (%s원) - %d개\n", matchCount,
                formatPrize(PRIZE_MONEY.get(matchResultWithoutBonus)), countWithoutBonus);

            // 5개 일치하고 보너스 볼이 일치하는 경우 별도 출력
            if (matchCount == 5) {
                System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                    formatPrize(PRIZE_MONEY.get(matchResultWithBonus)), countWithBonus);
            }
        }

        // 총 수익률 계산 및 출력
        float profitRate = getProfitRate(totalWinnings);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private String formatPrize(Integer prize) {
        return String.format("%,d", prize);
    }

    private float getProfitRate(float totalWinnings) {
        // 수익률 계산: (총 당첨금 / 투자한 총 금액) * 100
        float profitRate = (totalWinnings / totalAmount) * 100;
        return profitRate;
    }
}
