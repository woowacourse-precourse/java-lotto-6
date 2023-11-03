package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private final Map<LottoRank, Integer> resultByLottoRank = new EnumMap<>(LottoRank.class);

    public WinningResult(List<Lotto> lottos, WinningLotto winningLotto) {
        initializeResult();
        matchLottos(lottos, winningLotto);
    }

    private void initializeResult() {
        for (LottoRank lottoRank : LottoRank.values()) {
            resultByLottoRank.put(lottoRank, 0);
        }
    }

    private void matchLottos(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            LottoRank lottoRank = winningLotto.match(lotto);
            resultByLottoRank.put(lottoRank, resultByLottoRank.get(lottoRank) + 1);
        }
    }

    public Map<LottoRank, Integer> getResultByLottoRank() {
        return resultByLottoRank;
    }

    public int getPurchasedLottoCount() {
        return resultByLottoRank.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
