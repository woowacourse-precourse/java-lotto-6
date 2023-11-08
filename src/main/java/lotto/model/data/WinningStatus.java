package lotto.model.data;

import static lotto.util.AmountOfLotto.MAXIMUM_AMOUNT_OF_LOTTO;
import static lotto.util.ExceptionMessage.INVALID_PRIZE_MONEY;

import java.util.HashMap;
import java.util.Map;
import lotto.util.PrizeDetails;
import lotto.util.PrizeMoney;

/**
 * 등수에 따른 당첨 횟수를 제공한다.
 * 매치된 번호의 개수에 따라 등수를 계산하고 해당 등수에 따른 상금을 계산하는 기능을 제공한다.
 */
public class WinningStatus {
    private static final Integer NOT_WIN = 0;
    private static final Integer WIN = 1;
    private static final Long MINIMUM_PRIZE = 0L;
    private static final Long MAXIMUM_PRIZE =
            MAXIMUM_AMOUNT_OF_LOTTO.getPrice().longValue() * PrizeMoney.getPrizeMoney(1).longValue();

    private final Map<Integer, Integer> prizes = new HashMap<>();

    /**
     * 특정 등수에 따른 당첨 횟수를 반환한다.
     *
     * @param place 등수
     * @return 특정 등수에 따른 당첨 횟수
     */
    public Integer countOfPlace(Integer place) {
        return prizes.getOrDefault(place, NOT_WIN);
    }

    /**
     * 매치된 로또 번호의 개수, 보너스 볼 일치 여부에 따라 등수를 계산하고 해당 등수의 당첨 횟수를 증가한다.
     *
     * @param countOfMatchedLottoNumbers 로또 번호와 일치하는 당첨 번호의 개수
     * @param countOfMatchedBonusNumber 로또 번호에 보너스 번호가 포함된다면 1; 포함되지 않는다면 0
     */
    public void recordWinning(Integer countOfMatchedLottoNumbers, Integer countOfMatchedBonusNumber) {
        Integer prize = PrizeDetails.calculatePrize(countOfMatchedLottoNumbers, countOfMatchedBonusNumber);

        if (prize != NOT_WIN) {
            prizes.put(prize, prizes.getOrDefault(prize, NOT_WIN) + WIN);
        }
    }

    /**
     * 특정 등수에 따른 상금을 계산한다.
     *
     * @param prize 등수
     * @return 등수와 해당 등수의 상금을 곱한 상금
     */
    public Long calculatePrizeMoney(Integer prize) {
        Long totalPrizeMoney = PrizeMoney.getPrizeMoney(prize) * prizes.getOrDefault(prize, NOT_WIN).longValue();

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
