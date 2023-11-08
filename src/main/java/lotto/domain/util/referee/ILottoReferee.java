package lotto.domain.util.referee;

import lotto.domain.config.ScoreConfig;
import lotto.domain.entity.lotto.Lotto;
import lotto.domain.entity.lotto.WinningLotto;

public interface ILottoReferee {
    ScoreConfig determineRank(Lotto lotto, WinningLotto winningLotto);
}

