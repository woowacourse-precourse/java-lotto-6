package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EntireMatchResult {

    private static final int MATCH_COUNT_THREE = 3;
    private static final int MATCH_COUNT_SIX = 6;
    private final List<MatchResult> entireMatchResult;
    private static final Map<MatchResult, Integer> PRIZE_MONEY = initializePrizeMoney();

    public EntireMatchResult(List<MatchResult> entireMatchResult) {
        this.entireMatchResult = entireMatchResult;
    }

    public Map<MatchResult, Integer> calculateMatchCounts() {
        return entireMatchResult.stream()
            .collect(Collectors.toMap(Function.identity(), matchResult -> 1, Integer::sum));
    }

    private static Map<MatchResult, Integer> initializePrizeMoney() {
        Map<MatchResult, Integer> prizeMoney = new HashMap<>();
        prizeMoney.put(new MatchResult(3, false), 5_000);
        prizeMoney.put(new MatchResult(4, false), 50_000);
        prizeMoney.put(new MatchResult(5, false), 1_500_000);
        prizeMoney.put(new MatchResult(5, true), 30_000_000);
        prizeMoney.put(new MatchResult(6, false), 2_000_000_000);
        return prizeMoney;
    }

    public void print() {
        System.out.println("당첨 통계\n---");

        Map<MatchResult, Integer> counts = calculateMatchCounts();
        for (int matchCount = MATCH_COUNT_THREE; matchCount <= MATCH_COUNT_SIX; matchCount++) {
            MatchResult matchResultWithoutBonus = new MatchResult(matchCount, false);
            MatchResult matchResultWithBonus = new MatchResult(matchCount, true);

            int countWithoutBonus = counts.getOrDefault(matchResultWithoutBonus, 0);
            int countWithBonus = counts.getOrDefault(matchResultWithBonus, 0);

            System.out.printf("%d개 일치 (%s원) - %d개\n", matchCount,
                formatPrize(PRIZE_MONEY.get(matchResultWithoutBonus)), countWithoutBonus);

            if (matchCount == 5) {
                System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                    formatPrize(PRIZE_MONEY.get(matchResultWithBonus)), countWithBonus);
            }
        }
    }

    private String formatPrize(Integer prize) {
        return String.format("%,d", prize);
    }
}
