package lotto.domain;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.Rank.LOSE;

public class Statistics {
    private static final int ONE = 1;
    private static final int ZERO = 0;
    private static final double ONE_HUNDRED = 100.0;
    private static final String ENTER = "\n";
    private final Map<Rank, Integer> results;

    public Statistics(List<Lotto> lottos, WinningLotto winningLotto, int bonus) {
        Map<Rank, Integer> results = initResults();
        for (Lotto lotto : lottos) {
            Rank rank = getRank(winningLotto, bonus, lotto);
            results.computeIfPresent(rank, (key, v) -> v + ONE);
        }
        this.results = results;
    }

    private Map<Rank, Integer> initResults() {
        Map<Rank, Integer> initialResults = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            initialResults.put(rank, ZERO);
        }
        return initialResults;
    }

    private Rank getRank(WinningLotto winningLotto, int bonus, Lotto lotto) {
        boolean hasBonus = lotto.contains(bonus);
        int matchCount = lotto.countMatch(winningLotto);
        return Rank.getRank(matchCount, hasBonus);
    }

    public String calculateRevenueRate(Buyer buyer) {
        long totalPrize = 0;
        for (Rank rank : results.keySet()) {
            totalPrize += rank.getPrize() * results.get(rank);
        }
        DecimalFormat rateFormat = new DecimalFormat("#,##0.0");
        return rateFormat.format(totalPrize / (float) buyer.getCost() * ONE_HUNDRED);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        DecimalFormat moneyFormat = new DecimalFormat("#,###");

        results.forEach((rank, count) -> {
            if (rank != LOSE) {
                String prize = moneyFormat.format(rank.getPrize());
                String message = String.format(rank.getMessage(), prize, count);
                stringBuilder.append(message).append(ENTER);
            }
        });
        return stringBuilder.toString();
    }

}
