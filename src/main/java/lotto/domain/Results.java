package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public Map<Prize, Integer> getPrizeResult() {
        List<Prize> prizes = toPrizes();
        Map<Prize, Integer> prizeResult = init();

        for (Prize prize : prizes) {
            prizeResult.put(prize, prizeResult.getOrDefault(prize, 0) + 1);
        }
        return prizeResult;
    }

    private List<Prize> toPrizes() {
        return results.stream()
                .map(result -> Prize.getPrize(result.getMatchCount(), result.isMatchBonus()))
                .toList();
    }

    private Map<Prize, Integer> init() {
        Map<Prize, Integer> prizeResult = new EnumMap<>(Prize.class);
        Arrays.stream(Prize.values())
                .forEach(prize -> prizeResult.put(prize, 0));

        return prizeResult;
    }
}