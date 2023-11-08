package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import lotto.domain.enums.Rank;

public class RankResult {
    private final Map<Rank, Integer> rankResult;

    public RankResult() {
        rankResult = new EnumMap<>(Rank.class);

        Arrays.stream(Rank.values())
                .forEach(rank -> rankResult.put(rank, 0));
    }

    public void calcuateRankResult(Lottos lottos, LottoResult lottoResult) {
        lottos.getLottos()
                .forEach(lotto -> {
                    Rank rank = Rank.getLottoRank(lotto, lottoResult);
                    updateRankResult(rank);
                });
    }

    private void updateRankResult(Rank rank) {
        rankResult.put(rank, getRankCount(rank) + 1);
    }

    public int getRankCount(Rank rank) {
        return rankResult.get(rank);
    }
}
