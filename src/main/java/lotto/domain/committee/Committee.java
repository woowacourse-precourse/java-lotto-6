package lotto.domain.committee;

import java.util.List;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.money.Money;
import lotto.domain.prize.Prize;
import lotto.domain.prize.PrizeResult;

public class Committee {
    private final PrizeResult prizeResult;
    private int totalWinningAmount;

    public Committee() {
        prizeResult = new PrizeResult();
        totalWinningAmount = 0;
    }

    public void match(Lottos lottos, WinningLotto winningLotto) {
        List<Prize> prizes = lottos.match(winningLotto);
        prizes.forEach(prize -> {
            prizeResult.addResultCount(prize);
            totalWinningAmount += prize.getWinningAmount();
        });
    }

    public int getResultCount(Prize prize) {
        return prizeResult.getResultCount(prize);
    }

    public float calculateEarningsRate(Money money) {
        return money.calculateEarningsRate(totalWinningAmount);
    }
}
