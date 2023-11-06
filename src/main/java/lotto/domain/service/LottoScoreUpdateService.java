package lotto.domain.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.config.ScoreConfig;
import lotto.domain.entity.lotto.Lotto;
import lotto.domain.entity.lotto.WinningLotto;
import lotto.domain.util.referee.LottoReferee;

public class LottoScoreUpdateService {
    public List<ScoreConfig> update(List<Lotto> lottos, WinningLotto winningLotto) {
        List<ScoreConfig> scores = new ArrayList<>();

        for (Lotto lotto : lottos) {
            ScoreConfig score = LottoReferee.determineRank(lotto, winningLotto);
            scores.add(score);
        }

        return scores;
    }
}
