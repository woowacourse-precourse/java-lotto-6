package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum LottoResult {
    FIRST("6개 일치", 2_000_000_000),
    SECOND("5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD("5개 일치", 1_500_000),
    FOURTH("4개 일치", 50_000),
    FIFTH("3개 일치", 5_000),
    NONE("당첨되지 않았습니다", 0);

    private String description;
    private int prize;

    LottoResult(String description, int price) {
        this.description = description;
        this.prize = price;
    }

    public String getDescription() {
        return description;
    }

    public int getPrize() {
        return prize;
    }

    public static Map<LottoResult, Integer> aggregate(List<LottoResult> results) {
        Map<LottoResult, Integer> aggregated = new HashMap<>();
        for (LottoResult result : results) {
            aggregated.put(result, aggregated.getOrDefault(result, 0) + 1);
        }
        return aggregated;
    }

    public static double calculateReturnRate(Map<LottoResult, Integer> aggregatedResult, int income) {
        int outcome = Arrays.stream(LottoResult.values())
                .mapToInt(result ->
                        result.getPrize() * aggregatedResult.getOrDefault(result, 0)
                ).sum();
        return Math.round((double) outcome / income * 1000) / 10.0;
    }
}
