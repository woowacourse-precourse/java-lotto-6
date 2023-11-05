package lotto.domain.proxy;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Paper;

public interface PrizeHandler {
    void setNextPrizeHandler(PrizeHandler nextPrizeHandler);

    void process(Paper paper, Lotto lotto);

    String printWinningStatistics();

    int getTotalPrizeCount();

    double earnRate(int investedAmount);
}
