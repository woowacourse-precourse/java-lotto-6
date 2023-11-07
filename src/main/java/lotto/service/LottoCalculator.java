package lotto.service;

import lotto.domain.purchase.PurchaseLottos;
import lotto.domain.statics.WinningGrade;
import lotto.domain.statics.WinningStatics;
import lotto.domain.winning.WinningLotto;

public class LottoCalculator {

    public WinningStatics getWinningStatic(
            final PurchaseLottos purchaseLottos,
            final WinningLotto winningLotto
    ) {
        final WinningStatics statics = new WinningStatics();

        purchaseLottos.lottos().forEach(lotto -> {
            final WinningGrade winningGrade = winningLotto.matchLotto(lotto);
            statics.addWinningCount(winningGrade);
        });

        return statics;
    }

}
