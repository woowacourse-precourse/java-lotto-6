package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.enums.Score;

public class GameResult {

    private final Map<Score, Integer> lottoResults;

    public GameResult(List<Lotto> lottos, WinningLotto winningLotto) {
        lottoResults = new EnumMap<>(Score.class);
        matchLottos(lottos, winningLotto);
    }

    private void matchLottos(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            Score scoreByMatch = winningLotto.matchLotto(lotto);
            lottoResults.put(scoreByMatch, lottoResults.getOrDefault(scoreByMatch, 0) + 1);
        }
    }

    public Map<Score, Integer> getLottoResults() {
        return lottoResults;
    }
}
