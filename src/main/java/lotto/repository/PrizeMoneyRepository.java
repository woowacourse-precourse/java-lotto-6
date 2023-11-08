package lotto.repository;

import lotto.domain.LottoRanking;

import java.util.EnumMap;
import java.util.Map;

public class PrizeMoneyRepository {
    private static Map<LottoRanking, Integer> store = new EnumMap<>(LottoRanking.class);

    static {
        addPrizeMoneyOf(LottoRanking.FIRST);
        addPrizeMoneyOf(LottoRanking.SECOND);
        addPrizeMoneyOf(LottoRanking.THIRD);
        addPrizeMoneyOf(LottoRanking.FOURTH);
        addPrizeMoneyOf(LottoRanking.FIFTH);
        addPrizeMoneyOf(LottoRanking.NOTHING);
    }

    private static void addPrizeMoneyOf(LottoRanking lottoRanking) {
        store.put(lottoRanking, lottoRanking.getPrizeMoney());
    }

    public int findByLottoRanking(LottoRanking lottoRanking) {
        return store.get(lottoRanking);
    }
}
