package lotto.domain;

import lotto.InitLotto;
import lotto.Lotto;

public class CompareLottos {
    public static void compareLottos(InitLotto initLotto) {
        Stats.setPurchased(initLotto.getAmount());
        for (Lotto lotto : initLotto.getLottos()) {
            LottoPrize lottoPrize = RankCalculator.calculateRank(lotto, initLotto.getWinningNumbers(), initLotto.getBonusNumber());
            Stats.update(lottoPrize);
        }
        Stats.printStat();
    }
}
