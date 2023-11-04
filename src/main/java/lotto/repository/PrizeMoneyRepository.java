package lotto.repository;

import lotto.domain.LottoRanking;

import java.util.EnumMap;
import java.util.Map;

public class PrizeMoneyRepository {
    private static Map<LottoRanking, Integer> store = new EnumMap<>(LottoRanking.class);

    static {
        store.put(LottoRanking.FIRST, 2000000000);
        store.put(LottoRanking.SECOND, 30000000);
        store.put(LottoRanking.THIRD, 1500000);
        store.put(LottoRanking.FOURTH, 50000);
        store.put(LottoRanking.FIFTH, 5000);
    }

    public int findByLottoRanking(LottoRanking lottoRanking) {
        return store.get(lottoRanking);
    }
}
