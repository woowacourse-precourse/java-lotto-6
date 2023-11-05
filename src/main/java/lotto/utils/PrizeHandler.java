package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.Paper;

public interface PrizeHandler {
    void setNextPrizeHandler(PrizeHandler nextPrizeHandler);

    void process(Paper paper, Lotto lotto);

    String printWinningStatistics();

    int getTotalPrizeCount();
}
