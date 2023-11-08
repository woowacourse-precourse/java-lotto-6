package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> result = new EnumMap<>(Rank.class);

    public static LottoResult of(final LottoBundle lottoBundle, final WinningNumber winningNumber) {
        return new LottoResult(lottoBundle, winningNumber);
    }

    public long calculatePrize() {
        return result.keySet().stream()
                .mapToLong(rank -> (long) rank.getPrize() * result.get(rank))
                .sum();
    }

    public int countRank(final Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    private LottoResult(LottoBundle lottoBundle, final WinningNumber winningNumber) {
        lottoBundle.getLottos().stream()
                .map(lotto -> calculateRank(winningNumber, lotto))
                .forEach(this::putRank);
    }

    private void putRank(final Rank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    private static Rank calculateRank(final WinningNumber winningNumber, final Lotto lotto) {
        return Rank.createRank(lotto.countMatchingNumbers(winningNumber.lotto()),
                lotto.contains(winningNumber.bonusNumber()));
    }
}
