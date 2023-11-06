package lotto.domain.util.referee;

import lotto.domain.config.ScoreConfig;
import lotto.domain.entity.lotto.Lotto;
import lotto.domain.entity.Score;
import lotto.domain.entity.lotto.WinningLotto;

public class LottoReferee {
    private LottoReferee() {
    }

    public static ScoreConfig determineRank(Lotto lotto, WinningLotto winningLotto) {
        Score score = new Score();

        numbersMatch(lotto, winningLotto, score);
        bonusMatch(lotto, winningLotto, score);

        return ScoreConfig.valueOf(score.getMatchCount(), score.isBonusMatch());
    }

    private static void numbersMatch(Lotto lotto, WinningLotto winningLotto, Score score) {
        for (Integer number : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                score.matchOneNumber();
            }
        }
    }

    private static void bonusMatch(Lotto lotto, WinningLotto winningLotto, Score score) {
        if (lotto.getNumbers().contains(winningLotto)) {
            score.matchBonus();
        }
    }
}
