package lotto.constants;

import java.util.NoSuchElementException;
import java.util.Objects;
import lotto.model.Lotto;

public enum LottoPrize {

    FIRST_PRIZE(6, 2000000000, false),
    SECOND_PRIZE(5, 30000000, true),
    THIRD_PRIZE(5, 1500000, false),
    FOURTH_PRIZE(4, 50000, false),
    FIFTH_PRIZE(3, 5000, false);

    private final Integer matchedNumberCount;
    private final Integer prizeMoney;
    private final Boolean isBonusNumberMatch;

    LottoPrize(Integer matchedNumberCount, Integer prizeMoney, Boolean isBonusNumberMatch) {
        this.matchedNumberCount = matchedNumberCount;
        this.prizeMoney = prizeMoney;
        this.isBonusNumberMatch = isBonusNumberMatch;
    }

    public static LottoPrize valueOf(Boolean hasBonusNumber, Integer countMatchNumber) {
        if (hasBonusNumber && countMatchNumber == 5) {
            return SECOND_PRIZE;
        }

        if (!hasBonusNumber && countMatchNumber == 5) {
            return THIRD_PRIZE;
        }

        for (LottoPrize lottoPrize : LottoPrize.values()) {
            if (Objects.equals(countMatchNumber, lottoPrize.matchedNumberCount)) {
                return lottoPrize;
            }
        }

        throw new NoSuchElementException("[ERROR] 보너스 넘버와 로또에 맞는 등수가 없습니다.");
    }
}
