package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final WinningLotto winningLotto;
    private final Lottos lottos;
    private final Map<Prize, Integer> results;

    public LottoResult(WinningLotto winningLotto, Lottos lottos) {
        this.winningLotto = winningLotto;
        this.lottos = lottos;
        this.results = calculateResults();
    }

    private Map<Prize, Integer> calculateResults() {
        Map<Prize, Integer> calculation = new EnumMap<>(Prize.class);
        for (Prize prize : Prize.values()) {
            calculation.put(prize, 0);
        }

        lottos.getLottos().forEach(lotto -> {
            int matchCount = lotto.matchCount(winningLotto);
            boolean matchBonus = lotto.isMatchBonus(winningLotto);
            Prize prize = Prize.valueOf(matchCount, matchBonus);
            calculation.put(prize, calculation.get(prize) + 1);
        });

        return calculation;
    }

    public int getCountForPrize(Prize prize) {
        return results.getOrDefault(prize, 0);
    }

    public double calculateProfitRate(Money purchaseAmount) {
        long totalReward = results.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getReward() * entry.getValue())
                .sum();
        double profit = (double) totalReward ;
        return (profit / purchaseAmount.getAmount()) * 100;
    }

}
