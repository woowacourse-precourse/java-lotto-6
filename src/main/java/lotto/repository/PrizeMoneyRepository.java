package lotto.repository;

import lotto.domain.LottoRanking;

import java.util.EnumMap;
import java.util.Map;

public class PrizeMoneyRepository {
    private static final int FIRST_PRIZE_MONEY = 2000000000;
    private static final int SECOND_PRIZE_MONEY = 30000000;
    private static final int THIRD_PRIZE_MONEY = 1500000;
    private static final int FOURTH_PRIZE_MONEY = 50000;
    private static final int FIFTH_PRIZE_MONEY = 5000;
    private static final int NOTHING_PRIZE_MONEY = 0;

    private static Map<LottoRanking, Integer> store = new EnumMap<>(LottoRanking.class);

    static {
        store.put(LottoRanking.FIRST, FIRST_PRIZE_MONEY);
        store.put(LottoRanking.SECOND, SECOND_PRIZE_MONEY);
        store.put(LottoRanking.THIRD, THIRD_PRIZE_MONEY);
        store.put(LottoRanking.FOURTH, FOURTH_PRIZE_MONEY);
        store.put(LottoRanking.FIFTH, FIFTH_PRIZE_MONEY);
        store.put(LottoRanking.NOTHING, NOTHING_PRIZE_MONEY);
    }

    public int findByLottoRanking(LottoRanking lottoRanking) {
        return store.get(lottoRanking);
    }
}
