package lotto;

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

    public float evaluateTotalProfit() {
        float totalWinnings = 0;

        for (MatchResult matchResult : matchResults) {
            totalWinnings += PRIZE_MONEY.getOrDefault(matchResult, 0);
        }

        float profitRate = getProfitRate(totalWinnings);

        // 결과 출력
        System.out.println("당첨 통계" + "\n" + "---");
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);

        return profitRate;
    }

    private float getProfitRate(float totalWinnings) {
        // 수익률 계산: (총 당첨금 / 투자한 총 금액) * 100
        float profitRate = (totalWinnings / totalAmount) * 100;
        return profitRate;
    }
}
