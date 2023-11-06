package lotto.Domain.LottoResult;

import static lotto.Domain.LottoResult.Prize.*;
import static lotto.Domain.LottoResult.Rank.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private Map<Integer, Prize> lottoResult;

    private LottoResult() {
        this.lottoResult = new LinkedHashMap<>();
        this.lottoResult.put(FIRST.getRank(), FIRST_PRIZE);
        this.lottoResult.put(SECOND.getRank(), SECOND_PRIZE);
        this.lottoResult.put(THIRD.getRank(), THIRD_PRIZE);
        this.lottoResult.put(FOURTH.getRank(), FOURTH_PRIZE);
        this.lottoResult.put(FIFTH.getRank(), FIFTH_PRIZE);
    }

    public static LottoResult from() {
        return new LottoResult();
    }
    public void IncreaseWinningCount(Integer rank) {
        lottoResult.get(rank).IncreaseWinningCount();
    }

    public List<Prize> findAllPrize() {
        return new ArrayList<>(lottoResult.values());
    }

    public int findTotalAward() {
        return lottoResult.values().stream()
                .mapToInt(prize -> prize.getAward() * prize.getWinningCount())
                .sum();
    }
}
