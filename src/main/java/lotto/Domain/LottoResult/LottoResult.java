package lotto.Domain.LottoResult;

import static lotto.Domain.LottoResult.Prize.*;
import static lotto.Domain.LottoResult.Rank.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private Map<Integer, Prize> lottoResultSet;

    private LottoResult() {
        this.lottoResultSet = new LinkedHashMap<>();
        this.lottoResultSet.put(FIRST.getValue(), FIRST_PRIZE);
        this.lottoResultSet.put(SECOND.getValue(), SECOND_PRIZE);
        this.lottoResultSet.put(THIRD.getValue(), THIRD_PRIZE);
        this.lottoResultSet.put(FOURTH.getValue(), FOURTH_PRIZE);
        this.lottoResultSet.put(FIFTH.getValue(), FIFTH_PRIZE);
    }

    public static LottoResult from() {
        return new LottoResult();
    }
    public void increaseWinningCount(Integer rank) {
        lottoResultSet.get(rank).increaseWinningCount();
    }

    public List<Prize> findAllPrize() {
        return new ArrayList<>(lottoResultSet.values());
    }

    public int findTotalAward() {
        return lottoResultSet.values().stream()
                .mapToInt(prize -> prize.getAward() * prize.getWinningCount())
                .sum();
    }
}
