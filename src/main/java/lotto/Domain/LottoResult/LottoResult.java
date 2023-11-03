package lotto.Domain.LottoResult;

import static lotto.Domain.LottoResult.Prize.*;
import static lotto.Domain.LottoResult.Rank.*;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    Map<Integer, Prize> lottoResult;

    public LottoResult() {
        this.lottoResult = new HashMap<>();
        this.lottoResult.put(FIRST.getRank(), FIRST_PRIZE);
        this.lottoResult.put(SECOND.getRank(), SECOND_PRIZE);
        this.lottoResult.put(THIRD.getRank(), THIRD_PRIZE);
        this.lottoResult.put(FOURTH.getRank(), FOURTH_PRIZE);
        this.lottoResult.put(FIFTH.getRank(), FIFTH_PRIZE);
    }

    public void addPrizeCount(Integer rank) {
        lottoResult.get(rank).addCount();
    }

    public Prize findPrizeByRank(Integer rank) {
        return lottoResult.get(rank);
    }
}
