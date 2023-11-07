package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private static final int INIT_NUM = 1;
    private final Map<LottoRank, Integer> results;

    public LottoResult(final Map<LottoRank, Integer> results) {
        this.results = results;
    }

    public static LottoResult determineWinnings(final WinningLotto winningLotto, final Lottos lottos) {
        EnumMap<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : lottos.getLottos()) {
            // 현재 로또가 몇등인지 구함
            LottoRank rank = winningLotto.match(lotto);
            results.merge(rank, INIT_NUM, Integer::sum);
        }
        return new LottoResult(results);
    }

    public int getCount(final LottoRank rank) {
        return results.getOrDefault(rank, 0);
    }

    public Map<LottoRank, Integer> getResults() {
        return results;
    }

}
