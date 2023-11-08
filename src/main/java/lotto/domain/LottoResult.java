package lotto.domain;

import static lotto.domain.constants.LottoConstants.LOTTO_PRICE;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> result = new EnumMap<>(Rank.class);

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        lottos.stream()
                .map(lotto -> Rank.determineRank(lotto, winningLotto))
                .forEach(rank -> result.merge(rank, 1, Integer::sum));
    }

    public long sumTotalPrizeMoney() {
        return result.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    public int calculateTotalPurchaseAmount() {
        return sumTotalLottoCount() * LOTTO_PRICE;
    }

    public int sumTotalLottoCount() {
        return result.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int countRank(Rank rank) {
        return result.getOrDefault(rank, 0);
    }
}
