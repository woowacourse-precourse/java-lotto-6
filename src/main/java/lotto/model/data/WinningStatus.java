package lotto.model.data;

import java.util.HashMap;
import java.util.Map;
import lotto.util.PrizeDetails;

public class WinningStatus {
    private static final Integer NOT_WIN = 0;

    private Map<Integer, Integer> prizes;

    public WinningStatus() {
        prizes = new HashMap<>();
    }

    public Integer countOfPlace(Integer place) {
        return prizes.getOrDefault(place, 0);
    }

    public void winning(Integer countOfMatchedLottoNumbers, Integer countOfMatchedBonusNumber) {
        Integer prize = PrizeDetails.calculatePrize(countOfMatchedLottoNumbers, countOfMatchedBonusNumber);

        if (prize != NOT_WIN) {
            prizes.put(prize, prizes.getOrDefault(prize, 0) + 1);
        }
    }
}
