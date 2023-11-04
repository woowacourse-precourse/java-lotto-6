package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResultCalculator {

    private static final int DEFAULT_VALUE = 0;
    private static final int ONE_VALUE = 1;

    public Map<Rank, Integer> calculateWinningStatus(final WinningLotto winningLotto, final Lottos lottos) {
        Map<Rank, Integer> winningStatus = new EnumMap<>(Rank.class);
        List<Lotto> lottoList = lottos.getLottos();

        for (Lotto lotto : lottoList) {
            Rank rank = calculateRank(winningLotto, lotto);
            winningStatus.put(rank, winningStatus.getOrDefault(rank, DEFAULT_VALUE) + ONE_VALUE);
        }

        return winningStatus;
    }

    private Rank calculateRank(final WinningLotto winningLotto, final Lotto lotto) {
        int sameCount = winningLotto.countMatchingNumbers(lotto.getNumbers());
        boolean matchBonus = winningLotto.hasMatchingBonus(lotto.getNumbers());
        return Rank.of(sameCount, matchBonus);
    }

    public double getReturnRate(final Map<Rank, Integer> status, final Money money) {
        long sumOfPrice = calculateSumOfPrice(status);
        return money.calculateReturnRate(sumOfPrice);
    }

    private long calculateSumOfPrice(final Map<Rank, Integer> status) {
        return status.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
}
