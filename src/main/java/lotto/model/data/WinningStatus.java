package lotto.model.data;

import static lotto.util.AmountOfLotto.MAXIMUM_AMOUNT_OF_LOTTO;
import static lotto.util.ExceptionMessage.INVALID_PRIZE_MONEY;

import java.util.HashMap;
import java.util.Map;
import lotto.util.PrizeDetails;
import lotto.util.PrizeMoney;

public class WinningStatus {
    private static final Integer NOT_WIN = 0;
    private static final Long MINIMUM_PRIZE = 0L;
    private static final Long MAXIMUM_PRIZE =
            MAXIMUM_AMOUNT_OF_LOTTO.getPrice().longValue() * PrizeMoney.getPrizeMoney(1).longValue();

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

    public Long calculatePrizeMoney(Integer prize, Integer countOfWinning) {
        Long totalPrizeMoney = PrizeMoney.getPrizeMoney(prize) * countOfWinning.longValue();

        checkMinimum(totalPrizeMoney);
        checkMaximum(totalPrizeMoney);

        return totalPrizeMoney;
    }

    private void checkMinimum(Long totalPrizeMoney) {
        if (totalPrizeMoney < MINIMUM_PRIZE) {
            throw new IllegalArgumentException(INVALID_PRIZE_MONEY.getMessage());
        }
    }

    private void checkMaximum(Long totalPrizeMoney) {
        if (totalPrizeMoney > MAXIMUM_PRIZE) {
            throw new IllegalArgumentException(INVALID_PRIZE_MONEY.getMessage());
        }
    }
}
