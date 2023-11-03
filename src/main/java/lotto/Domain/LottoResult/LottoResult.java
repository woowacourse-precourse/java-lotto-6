package lotto.Domain.LottoResult;

import static lotto.Domain.LottoResult.Prize.*;
import static lotto.Domain.LottoResult.Rank.*;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    Map<Rank, Prize> lottoResult;

    public LottoResult() {
        this.lottoResult = new HashMap<>();
        this.lottoResult.put(FIRST, FIRST_PRIZE);
        this.lottoResult.put(SECOND, SECOND_PRIZE);
        this.lottoResult.put(THIRD, THIRD_PRIZE);
        this.lottoResult.put(FOURTH, FOURTH_PRIZE);
        this.lottoResult.put(FIFTH, FIFTH_PRIZE);
    }

    public void addPrizeCount(Rank rank) {
        lottoResult.get(rank).addCount();
    }

    public Prize findPrizeByRank(Rank rank) {
        return lottoResult.get(rank);
    }
}
