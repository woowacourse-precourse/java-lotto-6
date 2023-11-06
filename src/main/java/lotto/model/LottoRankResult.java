package lotto.model;

import static java.util.Collections.synchronizedMap;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoRankResult {
    private final Map<LottoRank, Integer> result;

    public LottoRankResult() {
        List<LottoRank> ranks = Arrays.asList(LottoRank.values());
        result = synchronizedMap(new EnumMap<>(LottoRank.class));
        ranks.forEach(rank -> result.put(rank, 0));
    }

    public void countWinningResult(final WinningLotto winningLotto, final Lotto lotto) {
        LottoRank rank = winningLotto.calculateLottoRank(lotto);
        result.put(rank, result.get(rank) + 1);
    }

    public int getCountByLottoRank(final LottoRank rank) {
        return result.get(rank);
    }

    public List<Integer> getCounts() {
        return result.values().stream()
                .collect(Collectors.toUnmodifiableList());
    }
}
