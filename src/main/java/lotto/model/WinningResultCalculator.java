package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResultCalculator {

    private static final int DEFAULT_VALUE = 0;
    private static final int INCREMENT = 1;

    public Map<Rank, Integer> calculateWinningStatus(final WinningLotto winningLotto, final Lottos lottos) {
        Map<Rank, Integer> winningStatus = new EnumMap<>(Rank.class);
        List<Lotto> purchasedLottos = lottos.getLottos();

        purchasedLottos.forEach(lotto -> {
            Rank rank = calculateRank(winningLotto, lotto);
            winningStatus.put(rank, winningStatus.getOrDefault(rank, DEFAULT_VALUE) + INCREMENT);
        });

        return winningStatus;
    }

    private Rank calculateRank(final WinningLotto winningLotto, final Lotto lotto) {
        int sameCount = winningLotto.countMatchingNumbers(lotto.getLottoNumbers());
        boolean matchBonus = winningLotto.hasMatchingBonus(lotto.getLottoNumbers());
        return Rank.of(sameCount, matchBonus);
    }

    public double getReturnRate(final Map<Rank, Integer> status, final Money money) {
        long sumOfPrice = calculateSumOfPrice(status);
        return money.calculateReturnRate(sumOfPrice);
    }

    private long calculateSumOfPrice(final Map<Rank, Integer> status) {
        return status.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey()
                        .getPrice() * entry.getValue())
                .sum();
    }
}
