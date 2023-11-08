package lotto.lotto;

import static lotto.lotto.LottoResult.FIFTH_PRIZE;
import static lotto.lotto.LottoResult.FIRST_PRIZE;
import static lotto.lotto.LottoResult.FOURTH_PRIZE;
import static lotto.lotto.LottoResult.PARTICIPATION_PRIZE;

import java.util.HashMap;
import java.util.Map;

final class LottoResultMapper {
    private static final Map<Integer, LottoResult> bingGoCountToLottoResult = new HashMap<>();

    static LottoResult fromBingGoCount(int bingGoCount) {
        if (bingGoCountToLottoResult.isEmpty()) {
            initMap();
        }
        if (bingGoCount >= 7 || bingGoCount < 0) {
            return PARTICIPATION_PRIZE;
        }
        return bingGoCountToLottoResult.get(bingGoCount);
    }

    private static void initMap() {
        bingGoCountToLottoResult.put(0, PARTICIPATION_PRIZE);
        bingGoCountToLottoResult.put(1, PARTICIPATION_PRIZE);
        bingGoCountToLottoResult.put(2, PARTICIPATION_PRIZE);
        bingGoCountToLottoResult.put(3, FIFTH_PRIZE);
        bingGoCountToLottoResult.put(4, FOURTH_PRIZE);
        bingGoCountToLottoResult.put(5, null);
        bingGoCountToLottoResult.put(6, FIRST_PRIZE);
    }
}
