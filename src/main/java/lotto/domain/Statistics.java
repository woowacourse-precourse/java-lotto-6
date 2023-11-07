package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private final Map<Rank, Integer> results;
    private final Buyer buyer;

    private Statistics(Map<Rank, Integer> results, Buyer buyer) {
        this.results = results;
        this.buyer = buyer;
    }

    public static Statistics calculate(List<Lotto> lottos, WinningLotto winningLotto, int bonus, Buyer buyer) {
        Map<Rank, Integer> results = initResults();
        for (Lotto lotto : lottos) {
            boolean hasBonus = lotto.contains(bonus);
            int matchCount = lotto.countMatch(winningLotto);
            Rank rank = Rank.getRank(matchCount, hasBonus);

            int count = results.get(rank) + 1;
            results.put(rank, count);
        }
        return new Statistics(results, buyer);
    }

    private static Map<Rank, Integer> initResults() {
        Map<Rank, Integer> initialResults = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            initialResults.put(rank, 0);
        }
        return initialResults;
    }

    public String calculateRevenueRate() {
        long totalPrize = 0;
        for (Rank rank : results.keySet()) {
            totalPrize += rank.getPrize() * results.get(rank);
        }
        DecimalFormat rateFormat = new DecimalFormat("#,##0.0");
        return rateFormat.format(totalPrize / (float) buyer.getCost() * 100.0);
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
