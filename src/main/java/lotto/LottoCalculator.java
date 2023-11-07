package lotto;

import lotto.model.Lottos;
import lotto.model.WinningGrade;
import lotto.model.WinningLotto;
import lotto.model.WinningStatics;

public class LottoCalculator {

    public WinningStatics getWinningStatic(
            Lottos lottos,
            WinningLotto winningLotto
    ) {
        WinningStatics statics = new WinningStatics();

        lottos.getLottos().forEach(lotto -> {
            WinningGrade winningGrade = winningLotto.matchLotto(lotto);
            statics.addWinningCount(winningGrade);
        });

        return statics;
    }

}
