package lotto.domain;

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

    public int countRank(Rank rank) {
        return result.getOrDefault(rank, 0);
    }
}
