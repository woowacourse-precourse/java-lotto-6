package lotto.model;

import static lotto.model.LottoRanking.FIFTH;
import static lotto.model.LottoRanking.FIRST;
import static lotto.model.LottoRanking.FORTH;
import static lotto.model.LottoRanking.SECOND;
import static lotto.model.LottoRanking.THIRD;

public class LottoProfit {

    private final String lottoProfit;

    private static long getTotalPrizeMoney() {
        return FIRST.getPrizeMoney() * FIRST.getCount()
                + SECOND.getPrizeMoney() + SECOND.getCount()
                + THIRD.getPrizeMoney() + THIRD.getCount()
                + FORTH.getPrizeMoney() + FORTH.getCount()
                + FIFTH.getPrizeMoney() + FIFTH.getCount();
    }


}
