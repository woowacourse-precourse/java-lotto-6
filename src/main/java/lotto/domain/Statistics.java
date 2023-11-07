package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private final Map<Rank, Integer> results;

    public Statistics(Map<Rank, Integer> results) {
        this.results = results;
    }

    public static Statistics calculate(List<Lotto> lottos, WinningLotto winningLotto, int bonus) {
        Map<Rank, Integer> results = initResults();
        for (Lotto lotto : lottos) {
            boolean hasBonus = lotto.contains(bonus);
            int matchCount = lotto.countMatch(winningLotto);
            Rank rank = Rank.getRank(matchCount, hasBonus);

            int count = results.get(rank) + 1;
            results.put(rank, count);
        }
        return new Statistics(results);
    }

    private static Map<Rank, Integer> initResults() {
        Map<Rank, Integer> initialResults = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            initialResults.put(rank, 0);
        }
        return initialResults;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        results.forEach((rank, count) -> {
            String message = String.format(rank.getMessage(), rank.getPrize(), count);
            stringBuilder.append(message).append("\n");
        });
        return stringBuilder.toString();
    }
}
