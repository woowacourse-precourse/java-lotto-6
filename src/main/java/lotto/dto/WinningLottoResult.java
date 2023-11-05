package lotto.dto;

import static java.util.Collections.synchronizedMap;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;

public class WinningLottoResult {
    private final Map<LottoRank, Integer> result;

    public WinningLottoResult() {
        List<LottoRank> ranks = Arrays.asList(LottoRank.values());
        result = synchronizedMap(new EnumMap<>(LottoRank.class));
        ranks.forEach(rank -> result.put(rank, 0));
    }

    public void countWinningResult(WinningLotto winningLotto, Lotto lotto) {
        LottoRank rank = winningLotto.calculateLottoRank(lotto);
        result.put(rank, result.get(rank) + 1);
    }

    public int getCountByLottoRank(LottoRank rank) {
        return result.get(rank);
    }
}
