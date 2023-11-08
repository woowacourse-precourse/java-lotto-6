package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Score;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;

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

    public double calculateRateOfReturn(Money money) {
        int purchaseMoney = money.getMoney();
        Long totalPrize = getTotalPrize();
        return (double) totalPrize / purchaseMoney * 100;
    }

    private Long getTotalPrize() {
        return Arrays.stream(Score.values())
                .mapToLong(score -> score.getPrize() * lottoResults.getOrDefault(score, 0))
                .sum();
    }

}
