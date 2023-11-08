package lotto.module.result;

import lotto.module.domain.TotalPrize;
import lotto.module.rank.Rank;
import lotto.module.rank.LottoPrizeTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 로또 당첨 결과를 담은 클래스
 */
public class LottoResult {
    private final Map<Rank, Integer> result;

    private LottoResult() {
        this.result = new HashMap<>();
        initialize();
    }

    public static LottoResult newInstance() {
        return new LottoResult();
    }

    public void add(Rank rank) {
        int defaultCount = 1;
        int addCount = 1;
        result.put(rank, result.getOrDefault(rank, defaultCount) + addCount);
    }

    public int getRankCount(Rank rank) {
        return result.get(rank);
    }

    public TotalPrize getTotalPrize() {
        long money = 0;
        for (Rank rank : result.keySet()) {
            int count = result.get(rank);
            money += (long) rank.getPrize() * count;
        }
        return new TotalPrize(money);
    }

    private void initialize() {
        int initializeCount = 0;

        result.put(LottoPrizeTable.FIRST_PLACE.getRank(), initializeCount);
        result.put(LottoPrizeTable.SECOND_PLACE.getRank(), initializeCount);
        result.put(LottoPrizeTable.THIRD_PLACE.getRank(), initializeCount);
        result.put(LottoPrizeTable.FOURTH_PLACE.getRank(), initializeCount);
        result.put(LottoPrizeTable.FIFTH_PLACE.getRank(), initializeCount);
    }

}
